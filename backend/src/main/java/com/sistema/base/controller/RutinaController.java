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

import com.sistema.base.DTO.Request.RutinaRequest;
import com.sistema.base.DTO.Response.RutinaResponse;
import com.sistema.base.service.RutinaService;

@RestController
@RequestMapping("/rutinas")
@CrossOrigin(origins = "*")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public ResponseEntity<List<RutinaResponse>> obtenerTodos() {
        return ResponseEntity.ok(rutinaService.obtenerTodos());
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<RutinaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rutinaService.obtenerPorId(id));
    }

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public ResponseEntity<RutinaResponse> guardar(@RequestBody RutinaRequest request) {
        return ResponseEntity.ok(rutinaService.guardar(request));
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<RutinaResponse> editar(
            @PathVariable Long id,
            @RequestBody RutinaRequest request) {

        return ResponseEntity.ok(rutinaService.editar(id, request));
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rutinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
