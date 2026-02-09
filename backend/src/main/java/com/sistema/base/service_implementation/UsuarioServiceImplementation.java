package com.sistema.base.service_implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.base.model.Usuario;
import com.sistema.base.repository.UsuarioRepository;
import com.sistema.base.service.UsuarioService;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public List<Usuario> obtenerTodos() {
        return userRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }

    // ------------------------------
    // NUEVOS MÉTODOS PARA REGISTRO Y VERIFICACIÓN
    // ------------------------------
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setActivo(false);

        String token = UUID.randomUUID().toString();
        usuario.setVerificationToken(token);

        usuario.setVerificationTokenExpira(
                LocalDateTime.now().plusHours(24));

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

        if (usuario == null) {
            return false; // token inexistente
        }

        if (Boolean.TRUE.equals(usuario.getActivo())) {
            return false; // ya verificado
        }

        if (usuario.getVerificationTokenExpira() == null ||
                usuario.getVerificationTokenExpira().isBefore(LocalDateTime.now())) {
            return false; // token vencido
        }

        // activar usuario
        usuario.setActivo(true);

        // limpiar token
        usuario.setVerificationToken(null);
        usuario.setVerificationTokenExpira(null);

        userRepository.save(usuario);
        return true;
    }

    public void solicitarResetPassword(String correo) {
        userRepository.findByCorreo(correo).ifPresent(usuario -> {
            String token = UUID.randomUUID().toString();
            usuario.setResetPasswordToken(token);
            usuario.setResetPasswordTokenExpira(
                    LocalDateTime.now().plusHours(1));
            userRepository.save(usuario);

            enviarMailReset(usuario);
        });

        // si no existe, no hacer nada
    }

    private void enviarMailReset(Usuario usuario) {

        String subject = "Restablecer contraseña";

        String urlReset = "http://localhost:8080/usuario/password/reset?token="
                + usuario.getResetPasswordToken();

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

        if (usuario == null) {
            return false; // token inválido
        }

        if (usuario.getResetPasswordTokenExpira() == null ||
                usuario.getResetPasswordTokenExpira().isBefore(LocalDateTime.now())) {
            return false; // token vencido
        }

        // 🔐 validar mínima
        if (nuevaPassword == null || nuevaPassword.length() < 8) {
            throw new RuntimeException("La contraseña debe tener al menos 8 caracteres");
        }

        // 🔒 encriptar y guardar
        usuario.setPassword(passwordEncoder.encode(nuevaPassword));

        // 🧹 limpiar token
        usuario.setResetPasswordToken(null);
        usuario.setResetPasswordTokenExpira(null);

        userRepository.save(usuario);
        return true;
    }

}
