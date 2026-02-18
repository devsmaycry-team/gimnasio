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

import com.sistema.base.DTO.Request.ClaseRequest;
import com.sistema.base.DTO.Response.ClaseResponse;
import com.sistema.base.service.ClaseService;

@RestController
@RequestMapping("/clase")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    // -------------------------
    // GET ALL
    // -------------------------
    @GetMapping("/todos")
    public List<ClaseResponse> obtenerTodos() {
        return claseService.obtenertodos();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping("/buscar/{id}")
    public ClaseResponse buscarPorId(@PathVariable Long id) {
        return claseService.obtenerPorId(id);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @PostMapping("/crear")
    public ClaseResponse crear(@RequestBody ClaseRequest dto) {
        return claseService.guardar(dto);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        claseService.eliminar(id);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @PutMapping("/editar/{id}")
    public ClaseResponse editar(
            @PathVariable Long id,
            @RequestBody ClaseRequest dto) {
        return claseService.editar(id, dto);
    }
}
