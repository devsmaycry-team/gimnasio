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

import com.sistema.base.DTO.Request.MedicionesRequest;
import com.sistema.base.DTO.Response.MedicionesResponse;
import com.sistema.base.service.MedicionesService;

@RestController
@RequestMapping("/api/mediciones")
public class MedicionesController {

    @Autowired
    private MedicionesService medicionesService;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<MedicionesResponse> obtenerTodos() {
        return medicionesService.obtenertodos();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public MedicionesResponse obtenerPorId(@PathVariable Long id) {
        return medicionesService.obtenerPorId(id);
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public MedicionesResponse guardar(@RequestBody MedicionesRequest request) {
        return medicionesService.guardar(request);
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public MedicionesResponse editar(@PathVariable Long id,
                                    @RequestBody MedicionesRequest request) {
        return medicionesService.editar(id, request);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        medicionesService.eliminar(id);
    }
}
