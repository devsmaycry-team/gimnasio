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

import com.sistema.base.DTO.Request.MembresiaRequest;
import com.sistema.base.DTO.Response.MembresiaResponse;
import com.sistema.base.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    // 🔹 Obtener todos
    @GetMapping
    public List<MembresiaResponse> obtenerTodos() {
        return membresiaService.obtenertodos();
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public MembresiaResponse obtenerPorId(@PathVariable Long id) {
        return membresiaService.obtenerPorId(id);
    }

    // 🔹 Crear
    @PostMapping
    public MembresiaResponse guardar(@RequestBody MembresiaRequest dto) {
        return membresiaService.guardar(dto);
    }

    // 🔹 Editar
    @PutMapping("/{id}")
    public MembresiaResponse editar(@PathVariable Long id, @RequestBody MembresiaRequest dto) {
        return membresiaService.editar(id, dto);
    }

    // 🔹 Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        membresiaService.eliminar(id);
    }
}
