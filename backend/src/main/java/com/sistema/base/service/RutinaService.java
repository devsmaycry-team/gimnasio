package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.RutinaRequest;
import com.sistema.base.DTO.Response.RutinaResponse;

public interface RutinaService {
     List<RutinaResponse> obtenertodos();
    RutinaResponse obtenerPorId(Long id);
    RutinaResponse guardar(RutinaRequest producto);
    void eliminar(Long id);
    RutinaResponse editar(Long id, RutinaRequest dto);

}
