package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.RegistroEjercicioRequest;
import com.sistema.base.DTO.Response.RegistroEjercicioResponse;

public interface RegistroEjercicioService {
    List<RegistroEjercicioResponse> obtenertodos();
    RegistroEjercicioResponse obtenerPorId(Long id);
    RegistroEjercicioResponse guardar(RegistroEjercicioRequest producto);
    void eliminar(Long id);
    RegistroEjercicioResponse editar(Long id, RegistroEjercicioRequest dto);

}
