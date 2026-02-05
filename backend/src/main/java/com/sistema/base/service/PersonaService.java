package com.sistema.base.service;

import java.util.List;

import com.sistema.base.model.Persona;

public interface PersonaService {
    List<Persona> obtenerTodos();
    Persona obtenerPorId(Long id);
    Persona guardar(Persona persona);
    void eliminar(Long id);
}
