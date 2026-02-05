package com.sistema.base.service_implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sistema.base.model.Usuario;
import com.sistema.base.repository.UsuarioRepository;
import com.sistema.base.service.UsuarioService;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

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
        usuario.setActivo(false); // inactivo hasta verificar
        String token = UUID.randomUUID().toString();
        usuario.setVerificationToken(token);

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

        usuario.setActivo(true);
        usuario.setVerificationToken(null);
        userRepository.save(usuario);
        return true;
    }
}
