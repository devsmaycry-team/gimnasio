package com.sistema.base.service;

import java.util.List;

import com.sistema.base.model.Usuario;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);

    // NUEVOS MÉTODOS
    Usuario registrarUsuario(Usuario usuario);
    boolean verificarUsuario(String token);
}
