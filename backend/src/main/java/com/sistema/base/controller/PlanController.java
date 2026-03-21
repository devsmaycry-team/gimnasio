package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.DTO.Request.PlanRequest;
import com.sistema.base.DTO.Response.PlanResponse;
import com.sistema.base.service.PlanService;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping
    public List<PlanResponse> obtenerTodos() {
        return planService.obtenertodos();
    }

    @GetMapping("/{id}")
    public PlanResponse obtenerPorId(@PathVariable Long id) {
        return planService.obtenerPorId(id);
    }

    // =========================
    // GET BY GYM
    // =========================
    @GetMapping("/planesgym/{id}")
    public List<PlanResponse> obtenerPorGimnasio(@PathVariable Long id) {
        return planService.obtenerPorGym(id);
    }

    @PostMapping
    public PlanResponse guardar(@RequestBody PlanRequest dto) {
        return planService.guardar(dto);
    }

    @PutMapping("/{id}")
    public PlanResponse editar(@PathVariable Long id, @RequestBody PlanRequest dto) {
        return planService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        planService.eliminar(id);
    }
}
