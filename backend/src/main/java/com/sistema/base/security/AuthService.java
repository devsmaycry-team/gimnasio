package com.sistema.base.security;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.RegistroDTO;
import com.sistema.base.model.Persona;
import com.sistema.base.model.Rol;
import com.sistema.base.model.UserRol;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.PersonaRepository;
import com.sistema.base.repository.RolRepository;
import com.sistema.base.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JavaMailSender mailSender;

    // ---------------- REGISTRO USUARIO NORMAL ----------------
    @Transactional
    public Usuario registrarUsuario(RegistroDTO dto) {

         if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            throw new RuntimeException("Las contraseñas no coinciden");
        }

        if (usuarioRepository.findByCorreo(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Crear Persona
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setCelular(dto.getCelular());
        persona = personaRepository.save(persona);

        // Crear Usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setActivo(false); // INACTIVO hasta verificar email
        usuario.setPersona(persona);

        // Generar token de verificación
        String token = UUID.randomUUID().toString();
        usuario.setVerificationToken(token);

        usuario = usuarioRepository.save(usuario);

        // Asignar rol CLIENTE
        Rol rolCliente = rolRepository.findByCargo("ROLE_CLIENTE")
                .orElseThrow(() -> new RuntimeException("El rol ROLE_CLIENTE no existe"));

        UserRol userRol = new UserRol();
        userRol.setUser(usuario);
        userRol.setRol(rolCliente);
        usuario.getUserRols().add(userRol);

        usuario = usuarioRepository.save(usuario);

        // Enviar email de verificación
        enviarMailVerificacion(usuario);

        return usuario;
    }

    // ---------------- REGISTRO ADMIN ----------------
    @Transactional
    public Usuario registrarAdmin(RegistroDTO dto) {

        if (usuarioRepository.findByCorreo(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setCelular(dto.getCelular());
        persona = personaRepository.save(persona);

        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setActivo(true); // ADMIN siempre activo
        usuario.setPersona(persona);
        usuario = usuarioRepository.save(usuario);

        Rol rolAdmin = rolRepository.findByCargo("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Rol ADMIN no existe"));

        UserRol userRol = new UserRol();
        userRol.setUser(usuario);
        userRol.setRol(rolAdmin);
        usuario.getUserRols().add(userRol);

        return usuarioRepository.save(usuario);
    }

    // ---------------- ENVÍO EMAIL ----------------
    private void enviarMailVerificacion(Usuario usuario) {
        String subject = "Confirma tu cuenta";
        String url = "http://localhost:4200/verify?token=" + usuario.getVerificationToken(); // Angular front-end
        String mensaje = "Hola, para activar tu cuenta haz click en el siguiente enlace: " + url;

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(usuario.getCorreo());
        mail.setSubject(subject);
        mail.setText(mensaje);

        mailSender.send(mail);
    }

    // ---------------- VERIFICAR USUARIO ----------------
    @Transactional
    public boolean verificarUsuario(String token) {
        Usuario usuario = usuarioRepository.findByVerificationToken(token);
        if (usuario == null) return false;

        usuario.setActivo(true);
        usuario.setVerificationToken(null);
        usuarioRepository.save(usuario);
        return true;
    }

    // ---------------- LOGIN ----------------
    public String login(String email, String password) {

        Usuario usuario = usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getActivo()) {
            throw new RuntimeException("Cuenta no activada. Revisa tu correo");
        }

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        var authorities = usuario.getUserRols().stream()
                .map(userRol -> new SimpleGrantedAuthority(userRol.getRol().getCargo()))
                .collect(Collectors.toList());

        var userDetails = new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(),
                usuario.getPassword(),
                authorities
        );

        return jwtUtil.generarToken(userDetails);
    }

    // ---------------- FROM TOKEN ----------------
    public Usuario getUsuarioFromToken(String header) {
        String token = header.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        return usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
