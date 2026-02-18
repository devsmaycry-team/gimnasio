package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.PlanRequest;
import com.sistema.base.DTO.Response.PlanResponse;
import com.sistema.base.model.Plan;
import com.sistema.base.repository.PlanRepository;
import com.sistema.base.service.PlanService;

@Service
public class PlanServiceImplementation implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<PlanResponse> obtenertodos() {
        return planRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PlanResponse obtenerPorId(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        return convertirAResponse(plan);
    }

    @Override
    public PlanResponse guardar(PlanRequest dto) {

        Plan plan = new Plan();
        plan.setNombre(dto.getNombre());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracion_dias(dto.getDuracion_dias());
        plan.setClases_incluidas(dto.getClases_incluidas());

        Plan guardado = planRepository.save(plan);

        return convertirAResponse(guardado);
    }

    @Override
    public PlanResponse editar(Long id, PlanRequest dto) {

        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        plan.setNombre(dto.getNombre());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracion_dias(dto.getDuracion_dias());
        plan.setClases_incluidas(dto.getClases_incluidas());

        Plan actualizado = planRepository.save(plan);

        return convertirAResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        planRepository.deleteById(id);
    }

    private PlanResponse convertirAResponse(Plan plan) {
        return new PlanResponse(
                plan.getId(),
                plan.getNombre(),
                plan.getPrecio(),
                plan.getDuracion_dias(),
                plan.getClases_incluidas()
        );
    }
}
