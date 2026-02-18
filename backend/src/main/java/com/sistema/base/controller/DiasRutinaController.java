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

import com.sistema.base.DTO.Request.DiaRutinaRequest;
import com.sistema.base.DTO.Response.DiaRutinaResponse;
import com.sistema.base.service.DiasRutinaService;

@RestController
@RequestMapping("/dias-rutina")
public class DiasRutinaController {

    @Autowired
    private DiasRutinaService diasRutinaService;

    // -------------------------
    // GET ALL
    // -------------------------
    @GetMapping("/todos")
    public List<DiaRutinaResponse> obtenerTodos() {
        return diasRutinaService.obtenertodos();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping("/buscar/{id}")
    public DiaRutinaResponse buscarPorId(@PathVariable Long id) {
        return diasRutinaService.obtenerPorId(id);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @PostMapping("/crear")
    public DiaRutinaResponse crear(@RequestBody DiaRutinaRequest dto) {
        return diasRutinaService.guardar(dto);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        diasRutinaService.eliminar(id);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @PutMapping("/editar/{id}")
    public DiaRutinaResponse editar(
            @PathVariable Long id,
            @RequestBody DiaRutinaRequest dto) {
        return diasRutinaService.editar(id, dto);
    }
}
