package com.sistema.base.service;

import java.util.List;

import com.sistema.base.DTO.Request.PlanRequest;
import com.sistema.base.DTO.Response.PlanResponse;

public interface PlanService {
    List<PlanResponse> obtenertodos();
    PlanResponse obtenerPorId(Long id);
    PlanResponse guardar(PlanRequest producto);
    void eliminar(Long id);
    PlanResponse editar(Long id, PlanRequest dto);

}
