package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.ClaseRequest;
import com.sistema.base.DTO.Response.ClaseResponse;

public interface ClaseService {
    List<ClaseResponse> obtenertodos();
    ClaseResponse obtenerPorId(Long id);
    ClaseResponse guardar(ClaseRequest producto);
    void eliminar(Long id);
    ClaseResponse editar(Long id, ClaseRequest dto);

}
