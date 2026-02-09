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

import com.sistema.base.DTO.Request.AsistenciaRequest;
import com.sistema.base.DTO.Response.AsistenciaResponse;
import com.sistema.base.service.AsistenciasService;


//============================
//El controller llama al service que a su vez usa los diferentes DTO
//============================
@RestController
@RequestMapping("/asistencia")
public class AsistenciasController {

    @Autowired
    private AsistenciasService asistenciasService;

    // -------------------------
    // GET ALL
    // -------------------------
    @GetMapping("/todos")
    public List<AsistenciaResponse> obtenerTodos() {
        return asistenciasService.obtenerTodos();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping("/buscar/{id}")
    public AsistenciaResponse buscarPorId(@PathVariable Long id) {
        return asistenciasService.obtenerPorId(id);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @PostMapping("/crear")
    public AsistenciaResponse crear(@RequestBody AsistenciaRequest dto) {
        return asistenciasService.guardar(dto);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        asistenciasService.eliminar(id);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @PutMapping("/editar/{id}")
    public AsistenciaResponse editar(
            @PathVariable Long id,
            @RequestBody AsistenciaRequest dto) {
        return asistenciasService.editar(id, dto);
    }
}
