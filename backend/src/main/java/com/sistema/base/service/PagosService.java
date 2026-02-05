package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.PagosRequest;
import com.sistema.base.DTO.Response.PagosResponse;

public interface PagosService {
     List<PagosResponse> obtenertodos();
    PagosResponse obtenerPorId(Long id);
    PagosResponse guardar(PagosRequest producto);
    void eliminar(Long id);
    PagosResponse editar(Long id, PagosRequest dto);

}
