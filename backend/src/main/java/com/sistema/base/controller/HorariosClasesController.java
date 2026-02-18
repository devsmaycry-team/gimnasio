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

import com.sistema.base.DTO.Request.HorariosClasesRequest;
import com.sistema.base.DTO.Response.HorariosClasesResponse;
import com.sistema.base.service.HorariosClasesService;

@RestController
@RequestMapping("/api/horarios-clases")
public class HorariosClasesController {

    @Autowired
    private HorariosClasesService horariosClasesService;

    // Obtener todos
    @GetMapping
    public List<HorariosClasesResponse> obtenerTodos() {
        return horariosClasesService.obtenertodos();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public HorariosClasesResponse obtenerPorId(@PathVariable Long id) {
        return horariosClasesService.obtenerPorId(id);
    }

    // Crear
    @PostMapping
    public HorariosClasesResponse guardar(@RequestBody HorariosClasesRequest request) {
        return horariosClasesService.guardar(request);
    }

    // Editar
    @PutMapping("/{id}")
    public HorariosClasesResponse editar(@PathVariable Long id,
                                         @RequestBody HorariosClasesRequest request) {
        return horariosClasesService.editar(id, request);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        horariosClasesService.eliminar(id);
    }
}
