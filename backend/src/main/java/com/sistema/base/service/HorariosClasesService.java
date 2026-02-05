package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.HorariosClasesRequest;
import com.sistema.base.DTO.Response.HorariosClasesResponse;

public interface HorariosClasesService {
    List<HorariosClasesResponse> obtenertodos();
    HorariosClasesResponse obtenerPorId(Long id);
    HorariosClasesResponse guardar(HorariosClasesRequest producto);
    void eliminar(Long id);
    HorariosClasesResponse editar(Long id, HorariosClasesRequest dto);

}
