package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.SocioRequest;
import com.sistema.base.DTO.Response.SocioResponse;

public interface SocioService {
     List<SocioResponse> obtenertodos();
    SocioResponse obtenerPorId(Long id);
    SocioResponse guardar(SocioRequest producto);
    void eliminar(Long id);
    SocioResponse editar(Long id, SocioRequest dto);

}
