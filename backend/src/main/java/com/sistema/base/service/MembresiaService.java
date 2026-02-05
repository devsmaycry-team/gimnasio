package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.MembresiaRequest;
import com.sistema.base.DTO.Response.MembresiaResponse;

public interface MembresiaService {
     List<MembresiaResponse> obtenertodos();
    MembresiaResponse obtenerPorId(Long id);
    MembresiaResponse guardar(MembresiaRequest producto);
    void eliminar(Long id);
    MembresiaResponse editar(Long id, MembresiaRequest dto);

}
