package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.RutinaEjercicioRequest;
import com.sistema.base.DTO.Response.RutinaEjercicioResponse;

public interface RutinaEjercicioService {
     List<RutinaEjercicioResponse> obtenertodos();
    RutinaEjercicioResponse obtenerPorId(Long id);
    RutinaEjercicioResponse guardar(RutinaEjercicioRequest producto);
    void eliminar(Long id);
    RutinaEjercicioResponse editar(Long id, RutinaEjercicioRequest dto);

}
