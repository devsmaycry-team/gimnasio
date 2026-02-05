package com.sistema.base.service;

import java.util.List;

import com.sistema.base.model.Rol;

public interface RolService {
    List<Rol> obtenerTodos();
    Rol obtenerPorId(Long id);
    Rol guardar(Rol rol);
    void eliminar(Long id);
}
