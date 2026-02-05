package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.EntrenadorRequest;
import com.sistema.base.DTO.Response.EntrenadorResponse;

public interface entrenadorService {
    List<EntrenadorResponse> obtenertodos();
    EntrenadorResponse obtenerPorId(Long id);
    EntrenadorResponse guardar(EntrenadorResponse producto);
    void eliminar(Long id);
    EntrenadorResponse editar(Long id, EntrenadorRequest dto);

}
