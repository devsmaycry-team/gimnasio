package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.RutinaRequest;
import com.sistema.base.DTO.Response.RutinaResponse;

public interface RutinaService {

    List<RutinaResponse> obtenerTodos();

    RutinaResponse obtenerPorId(Long id);

    RutinaResponse guardar(RutinaRequest rutinaRequest);

    RutinaResponse editar(Long id, RutinaRequest rutinaRequest);

    void eliminar(Long id);
}
