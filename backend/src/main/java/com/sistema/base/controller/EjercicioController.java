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

import com.sistema.base.DTO.Request.EjercicioRequest;
import com.sistema.base.DTO.Response.EjercicioResponse;
import com.sistema.base.service.EjercicioService;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    // -------------------------
    // GET ALL
    // -------------------------
    @GetMapping("/todos")
    public List<EjercicioResponse> obtenerTodos() {
        return ejercicioService.obtenerTodos();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping("/buscar/{id}")
    public EjercicioResponse buscarPorId(@PathVariable Long id) {
        return ejercicioService.obtenerPorId(id);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @PostMapping("/crear")
    public EjercicioResponse crear(@RequestBody EjercicioRequest request) {
        return ejercicioService.guardar(request);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        ejercicioService.eliminar(id);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @PutMapping("/editar/{id}")
    public EjercicioResponse editar(
            @PathVariable Long id,
            @RequestBody EjercicioRequest request) {
        return ejercicioService.editar(id, request);
    }
}
