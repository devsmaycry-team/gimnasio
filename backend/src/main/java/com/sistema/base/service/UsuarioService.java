package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Response.UsuarioResponse;
import com.sistema.base.model.Usuario;

public interface UsuarioService {
    List<UsuarioResponse> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    Usuario buscarPorCorreo(String correo);
    Usuario registrarUsuario(Usuario usuario);
    boolean verificarUsuario(String token);
    void solicitarResetPassword(String correo);
    boolean resetearPassword(String token, String nuevaPassword);
}
