package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.EntrenadorRequest;
import com.sistema.base.DTO.Response.EntrenadorResponse;

public interface EntrenadorService {

    List<EntrenadorResponse> obtenerTodos();
    public List<EntrenadorResponse> obtenerPorGimnasio(Long id);

    EntrenadorResponse obtenerPorId(Long id);

    EntrenadorResponse guardar(EntrenadorRequest request);

    EntrenadorResponse editar(Long id, EntrenadorRequest request);

    void eliminar(Long id);
}
