package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.EjercicioRequest;
import com.sistema.base.DTO.Response.EjercicioResponse;

public interface EjercicioService {

    List<EjercicioResponse> obtenerTodos();
    EjercicioResponse obtenerPorId(Long id);
    EjercicioResponse guardar(EjercicioRequest request);
    EjercicioResponse editar(Long id, EjercicioRequest request);
    void eliminar(Long id);
}
