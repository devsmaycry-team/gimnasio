package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.MedicionesRequest;
import com.sistema.base.DTO.Response.MedicionesResponse;

public interface MedicionesService {
     List<MedicionesResponse> obtenertodos();
    MedicionesResponse obtenerPorId(Long id);
    MedicionesResponse guardar(MedicionesRequest producto);
    void eliminar(Long id);
    MedicionesResponse editar(Long id, MedicionesRequest dto);

}
