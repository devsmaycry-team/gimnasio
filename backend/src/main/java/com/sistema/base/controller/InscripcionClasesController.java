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

import com.sistema.base.DTO.Request.InscripcionClasesRequest;
import com.sistema.base.DTO.Response.InscripcionClasesResponse;
import com.sistema.base.service.InscripcionClasesService;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionClasesController {

    @Autowired
    private InscripcionClasesService service;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<InscripcionClasesResponse> obtenerTodos() {
        return service.obtenertodos();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public InscripcionClasesResponse obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public InscripcionClasesResponse crear(@RequestBody InscripcionClasesRequest request) {
        return service.guardar(request);
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public InscripcionClasesResponse editar(
            @PathVariable Long id,
            @RequestBody InscripcionClasesRequest request) {
        return service.editar(id, request);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
