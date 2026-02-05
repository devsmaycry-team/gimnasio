package com.sistema.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.RegistroDTO;
import com.sistema.base.model.Persona;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.PersonaRepository;
import com.sistema.base.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class aa {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registrarUsuario(RegistroDTO dto) {

        if (usuarioRepository.existsByCorreo(dto.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // 1️⃣ Crear Persona
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setCelular(dto.getCelular());

        persona = personaRepository.save(persona);

        // 2️⃣ Crear Usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setActivo(true);
        usuario.setPersona(persona);

        return usuarioRepository.save(usuario);
    }
}
