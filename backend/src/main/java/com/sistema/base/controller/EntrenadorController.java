package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.base.DTO.Request.EntrenadorRequest;
import com.sistema.base.DTO.Response.EntrenadorResponse;
import com.sistema.base.service.EntrenadorService;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<EntrenadorResponse> obtenerTodos() {
        return entrenadorService.obtenerTodos();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public EntrenadorResponse obtenerPorId(@PathVariable Long id) {
        return entrenadorService.obtenerPorId(id);
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public EntrenadorResponse crear(@RequestBody EntrenadorRequest request) {
        return entrenadorService.guardar(request);
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public EntrenadorResponse editar(
            @PathVariable Long id,
            @RequestBody EntrenadorRequest request) {
        return entrenadorService.editar(id, request);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        entrenadorService.eliminar(id);
    }
}