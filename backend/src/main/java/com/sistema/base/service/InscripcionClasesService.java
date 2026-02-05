package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.InscripcionClasesRequest;
import com.sistema.base.DTO.Response.InscripcionClasesResponse;

public interface InscripcionClasesService {
    List<InscripcionClasesResponse> obtenertodos();
    InscripcionClasesResponse obtenerPorId(Long id);
    InscripcionClasesResponse guardar(InscripcionClasesRequest producto);
    void eliminar(Long id);
    InscripcionClasesResponse editar(Long id, InscripcionClasesRequest dto);

}
