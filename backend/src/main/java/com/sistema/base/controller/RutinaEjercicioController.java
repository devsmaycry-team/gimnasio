package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.DTO.Request.RutinaEjercicioRequest;
import com.sistema.base.DTO.Response.RutinaEjercicioResponse;
import com.sistema.base.service.RutinaEjercicioService;

@RestController
@RequestMapping("/rutina-ejercicios")
@CrossOrigin(origins = "*")
public class RutinaEjercicioController {

    @Autowired
    private RutinaEjercicioService rutinaEjercicioService;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public ResponseEntity<List<RutinaEjercicioResponse>> obtenerTodos() {
        return ResponseEntity.ok(rutinaEjercicioService.obtenertodos());
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<RutinaEjercicioResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rutinaEjercicioService.obtenerPorId(id));
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public ResponseEntity<RutinaEjercicioResponse> guardar(@RequestBody RutinaEjercicioRequest request) {
        return ResponseEntity.ok(rutinaEjercicioService.guardar(request));
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<RutinaEjercicioResponse> editar(
            @PathVariable Long id,
            @RequestBody RutinaEjercicioRequest request) {

        return ResponseEntity.ok(rutinaEjercicioService.editar(id, request));
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rutinaEjercicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
