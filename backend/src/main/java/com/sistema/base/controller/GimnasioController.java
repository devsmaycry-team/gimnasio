package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.base.DTO.Request.GimnasioRequest;
import com.sistema.base.DTO.Response.GimnasioResponse;
import com.sistema.base.service.GimnasioService;

@RestController
@RequestMapping("/gimnasios")
public class GimnasioController {

    @Autowired
    private GimnasioService gimnasioService;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<GimnasioResponse> obtenerTodos() {
        return gimnasioService.obtenerTodos();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public GimnasioResponse obtenerPorId(@PathVariable Long id) {
        return gimnasioService.obtenerPorId(id);
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public GimnasioResponse crear(@RequestBody GimnasioRequest request) {
        return gimnasioService.guardar(request);
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public GimnasioResponse editar(
            @PathVariable Long id,
            @RequestBody GimnasioRequest request) {
        return gimnasioService.editar(id, request);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        gimnasioService.eliminar(id);
    }
}