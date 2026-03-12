package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.GimnasioRequest;
import com.sistema.base.DTO.Response.GimnasioResponse;

public interface GimnasioService {

    List<GimnasioResponse> obtenerTodos();

    GimnasioResponse obtenerPorId(Long id);

    GimnasioResponse guardar(GimnasioRequest request);

    GimnasioResponse editar(Long id, GimnasioRequest request);

    void eliminar(Long id);
}