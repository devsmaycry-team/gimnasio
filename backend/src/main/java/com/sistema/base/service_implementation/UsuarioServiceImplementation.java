package com.sistema.base.service_implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.UserResponseDTO;
import com.sistema.base.DTO.Response.SocioResponse;
import com.sistema.base.DTO.Response.UsuarioResponse;
import com.sistema.base.model.Persona;
import com.sistema.base.model.Socio;
import com.sistema.base.model.UserRol;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.PersonaRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.repository.UsuarioRepository;
import com.sistema.base.repository.UsuarioRolRepository;
import com.sistema.base.service.UsuarioService;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    public List<UsuarioResponse> obtenerUsuariosPorGimnasio(Long gimnasioId) {
        List<Socio> socios = socioRepository.findByGimnasioId(gimnasioId);
        List<UsuarioResponse> usuarios = new ArrayList<>();
        for (Socio socio : socios) {
            Usuario usuario = socio.getUsuario();
            usuarios.add(
                    mapToResponse(usuario)
            );
        }
        return usuarios;
    }

    @Override
    public List<UsuarioResponse> obtenerTodos() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario user) {
        // Si la persona no tiene id, es nueva → guardarla primero
        if (user.getPersona() != null && user.getPersona().getId() == null) {
            Persona personaGuardada = personaRepository.save(user.getPersona());
            user.setPersona(personaGuardada);
        }

        // Encriptar password si viene en texto plano
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(user);
    }

    @Override
    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setActivo(false);

        String token = UUID.randomUUID().toString();
        usuario.setVerificationToken(token);
        usuario.setVerificationTokenExpira(LocalDateTime.now().plusHours(24));

        Usuario u = userRepository.save(usuario);
        enviarMailVerificacion(u);
        return u;
    }

    private void enviarMailVerificacion(Usuario usuario) {
        String subject = "Confirma tu cuenta";
        String urlVerificacion = "http://localhost:8080/usuario/verificar?token=" + usuario.getVerificationToken();
        String mensaje = "Hola, para activar tu cuenta haz click en el siguiente enlace: " + urlVerificacion;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(usuario.getCorreo());
        email.setSubject(subject);
        email.setText(mensaje);

        mailSender.send(email);
    }

    public boolean verificarUsuario(String token) {
        Usuario usuario = userRepository.findByVerificationToken(token);

        if (usuario == null) return false;
        if (Boolean.TRUE.equals(usuario.getActivo())) return false;
        if (usuario.getVerificationTokenExpira() == null ||
                usuario.getVerificationTokenExpira().isBefore(LocalDateTime.now())) return false;

        usuario.setActivo(true);
        usuario.setVerificationToken(null);
        usuario.setVerificationTokenExpira(null);

        userRepository.save(usuario);
        return true;
    }

    public void solicitarResetPassword(String correo) {
        userRepository.findByCorreo(correo).ifPresent(usuario -> {
            String token = UUID.randomUUID().toString();
            usuario.setResetPasswordToken(token);
            usuario.setResetPasswordTokenExpira(LocalDateTime.now().plusHours(1));
            userRepository.save(usuario);
            enviarMailReset(usuario);
        });
    }

    private void enviarMailReset(Usuario usuario) {
        String subject = "Restablecer contraseña";
        String urlReset = "http://localhost:8080/usuario/password/reset?token=" + usuario.getResetPasswordToken();
        String mensaje = """
                Hola,

                Recibimos una solicitud para cambiar tu contraseña.
                Hacé click en el siguiente enlace para continuar:

                """ + urlReset + """

                Si no fuiste vos, ignorá este mail.
                """;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(usuario.getCorreo());
        email.setSubject(subject);
        email.setText(mensaje);

        mailSender.send(email);
    }

    public boolean resetearPassword(String token, String nuevaPassword) {
        Usuario usuario = userRepository.findByResetPasswordToken(token);

        if (usuario == null) return false;
        if (usuario.getResetPasswordTokenExpira() == null ||
                usuario.getResetPasswordTokenExpira().isBefore(LocalDateTime.now())) return false;
        if (nuevaPassword == null || nuevaPassword.length() < 8) {
            throw new RuntimeException("La contraseña debe tener al menos 8 caracteres");
        }

        usuario.setPassword(passwordEncoder.encode(nuevaPassword));
        usuario.setResetPasswordToken(null);
        usuario.setResetPasswordTokenExpira(null);

        userRepository.save(usuario);
        return true;
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return userRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    private UsuarioResponse mapToResponse(Usuario usuario) {
        String nombre = null;
        String apellido = null;
        if (usuario.getPersona() != null) {
            nombre = usuario.getPersona().getNombre();
            apellido = usuario.getPersona().getApellido();
        }
        List<String> roles = new ArrayList<>();
        
        if (usuario.getUserRols() != null) {
            roles = usuario.getUserRols().stream()
                    .map(userRol -> userRol.getRol().getCargo())
                    .collect(Collectors.toList());
        }
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getActivo(),
                nombre,
                apellido,
                roles
        );
    }
}