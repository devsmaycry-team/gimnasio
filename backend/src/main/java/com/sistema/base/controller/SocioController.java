package com.sistema.base.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.DTO.Request.SocioRequest;
import com.sistema.base.DTO.Response.SocioResponse;
import com.sistema.base.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<SocioResponse>> obtenerTodos() {
        return ResponseEntity.ok(socioService.obtenertodos());
    }

    // Obtener por gym
    @GetMapping("/gimnasio/{id}")
    public ResponseEntity<List<SocioResponse>> obtenerPorgimnasio(@PathVariable Long id) {
        return ResponseEntity.ok(socioService.buscarPorGimnasio(id));
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<SocioResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(socioService.obtenerPorId(id));
    }

    // Crear socio
    @PostMapping
    public ResponseEntity<SocioResponse> guardar(@RequestBody SocioRequest dto) {
        return ResponseEntity.ok(socioService.guardar(dto));
    }

    // Editar socio
    @PutMapping("/{id}")
    public ResponseEntity<SocioResponse> editar(@PathVariable Long id, @RequestBody SocioRequest dto) {
        return ResponseEntity.ok(socioService.editar(id, dto));
    }

    // Eliminar socio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        socioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
