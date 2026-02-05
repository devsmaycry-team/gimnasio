package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.AsistenciaRequest;
import com.sistema.base.DTO.Response.AsistenciaResponse;

public interface AsistenciasService {
    List<AsistenciaResponse> obtenertodos();
    AsistenciaResponse obtenerPorId(Long id);
    AsistenciaResponse guardar(AsistenciaRequest producto);
    void eliminar(Long id);
    AsistenciaResponse editar(Long id, AsistenciaRequest dto);

}
