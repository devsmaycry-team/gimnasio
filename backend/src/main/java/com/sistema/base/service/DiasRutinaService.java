package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.DiaRutinaRequest;
import com.sistema.base.DTO.Response.DiaRutinaResponse;

public interface DiasRutinaService {
    List<DiaRutinaResponse> obtenertodos();
    DiaRutinaResponse obtenerPorId(Long id);
    DiaRutinaResponse guardar(DiaRutinaRequest producto);
    void eliminar(Long id);
    DiaRutinaResponse editar(Long id, DiaRutinaRequest dto);

}
