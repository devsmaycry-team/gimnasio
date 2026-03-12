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
import com.sistema.base.model.Gimnasio;
import com.sistema.base.model.Persona;
import com.sistema.base.model.Rol;
import com.sistema.base.model.Socio;
import com.sistema.base.model.UserRol;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.GimnasioRepository;
import com.sistema.base.repository.PersonaRepository;
import com.sistema.base.repository.RolRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Autowired
    private SocioRepository socioRepository;

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

        // Validar contraseñas
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            throw new RuntimeException("Las contraseñas no coinciden");
        }

        // Validar email duplicado
        if (usuarioRepository.findByCorreo(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Validar código gym
        if (dto.getCodigo_gym() == null || dto.getCodigo_gym().isEmpty()) {
            throw new RuntimeException("Debe ingresar el código del gimnasio");
        }

        // ======================
        // Crear Persona
        // ======================
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setCelular(dto.getCelular());

        persona = personaRepository.save(persona);

        // ======================
        // Crear Usuario
        // ======================
        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setActivo(false);
        usuario.setPersona(persona);

        // Token verificación
        String token = UUID.randomUUID().toString();
        usuario.setVerificationToken(token);

        usuario = usuarioRepository.save(usuario);

        // ======================
        // Asignar Rol CLIENTE
        // ======================
        Rol rolCliente = rolRepository.findByCargo("ROLE_CLIENTE")
                .orElseThrow(() -> new RuntimeException("El rol ROLE_CLIENTE no existe"));

        UserRol userRol = new UserRol();
        userRol.setUser(usuario);
        userRol.setRol(rolCliente);

        usuario.getUserRols().add(userRol);

        usuarioRepository.save(usuario);

        // ======================
        // Buscar gimnasio
        // ======================
        Gimnasio gimnasio = gimnasioRepository
                .findByCodigoGym(dto.getCodigo_gym())
                .orElseThrow(() -> new RuntimeException("Código de gimnasio inválido"));

        // ======================
        // Crear Socio
        // ======================
        Socio socio = new Socio();
        socio.setUsuario(usuario);
        socio.setGimnasio(gimnasio);

        socioRepository.save(socio);

        // ======================
        // Enviar email verificación
        // ======================
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

    // ---------------- MODIFICAR ROL USUARIO ----------------
    @Transactional
    public void cambiarRolUsuario(Long usuarioId, Long rolId) {  // Long en vez de String

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(rolId)  // busca por ID
                .orElseThrow(() -> new RuntimeException("Rol no existe: " + rolId));

        boolean tieneRol = usuario.getUserRols().stream()
                .anyMatch(ur -> ur.getRol().getId().equals(rolId));

        if (tieneRol) {
            throw new RuntimeException("El usuario ya tiene ese rol");
        }

        UserRol userRol = new UserRol();
        userRol.setUser(usuario);
        userRol.setRol(rol);
        usuario.getUserRols().add(userRol);

        usuarioRepository.save(usuario);
    }

    // ---------------- SACAR ROL USUARIO ----------------
    @Transactional
    public void quitarRolUsuario(Long usuarioId, Long rolId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no existe: " + rolId));

        boolean tieneRol = usuario.getUserRols().stream()
                .anyMatch(ur -> ur.getRol().getId().equals(rolId));

        if (!tieneRol) {
            throw new RuntimeException("El usuario no tiene ese rol");
        }

        usuario.getUserRols().removeIf(ur -> ur.getRol().getId().equals(rolId));

        usuarioRepository.save(usuario);
    }
    // ---------------- EDITAR ROL USUARIO (REEMPLAZA)----------------
    @Transactional
    public void editarRolUsuario(Long usuarioId, Long rolViejoId, Long rolNuevoId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rolNuevo = rolRepository.findById(rolNuevoId)
                .orElseThrow(() -> new RuntimeException("Rol nuevo no existe: " + rolNuevoId));

        boolean tieneRolViejo = usuario.getUserRols().stream()
                .anyMatch(ur -> ur.getRol().getId().equals(rolViejoId));

        if (!tieneRolViejo) {
            throw new RuntimeException("El usuario no tiene el rol a reemplazar");
        }

        boolean tieneRolNuevo = usuario.getUserRols().stream()
                .anyMatch(ur -> ur.getRol().getId().equals(rolNuevoId));

        if (tieneRolNuevo) {
            throw new RuntimeException("El usuario ya tiene el rol nuevo");
        }

        // Quitar viejo
        usuario.getUserRols().removeIf(ur -> ur.getRol().getId().equals(rolViejoId));

        // Agregar nuevo
        UserRol userRol = new UserRol();
        userRol.setUser(usuario);
        userRol.setRol(rolNuevo);
        usuario.getUserRols().add(userRol);

        usuarioRepository.save(usuario);
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
