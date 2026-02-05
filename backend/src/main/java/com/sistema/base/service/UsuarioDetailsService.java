package com.sistema.base.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.base.model.Usuario;
import com.sistema.base.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional(readOnly = true) // ← Mantiene la sesión abierta
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        // Forzar carga de roles
        usuario.getUserRols().size();
        
        System.out.println("🟨 [DEBUG] Usuario: " + email);
        usuario.getUserRols().forEach(ur -> {
            System.out.println("🟨 [DEBUG] Rol cargado: " + ur.getRol().getCargo());
        });
        
        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(),
                usuario.getPassword(),
                usuario.getUserRols().stream()
                    .map(userRol -> {
                        String cargo = userRol.getRol().getCargo();
                        System.out.println("🟩 [DEBUG] Authority creada: " + cargo);
                        return new SimpleGrantedAuthority(cargo); // ← SIN "ROLE_"
                    })
                    .collect(Collectors.toList())
        );
    }
}