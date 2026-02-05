package com.sistema.base.service;

import java.util.List;

import com.sistema.base.model.UserRol;

public interface UserRolService {
    List<UserRol> obtenerTodos();
    UserRol obtenerPorId(Long id);
    UserRol guardar(UserRol userRol);
    void eliminar(Long id);
}
