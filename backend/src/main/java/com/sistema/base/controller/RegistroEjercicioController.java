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

import com.sistema.base.DTO.Request.RegistroEjercicioRequest;
import com.sistema.base.DTO.Response.RegistroEjercicioResponse;
import com.sistema.base.service.RegistroEjercicioService;

@RestController
@RequestMapping("/api/registro-ejercicios")
public class RegistroEjercicioController {

    @Autowired
    private RegistroEjercicioService registroService;

    @GetMapping
    public List<RegistroEjercicioResponse> obtenerTodos() {
        return registroService.obtenertodos();
    }

    @GetMapping("/{id}")
    public RegistroEjercicioResponse obtenerPorId(@PathVariable Long id) {
        return registroService.obtenerPorId(id);
    }

    @PostMapping
    public RegistroEjercicioResponse guardar(@RequestBody RegistroEjercicioRequest dto) {
        return registroService.guardar(dto);
    }

    @PutMapping("/{id}")
    public RegistroEjercicioResponse editar(@PathVariable Long id,
                                            @RequestBody RegistroEjercicioRequest dto) {
        return registroService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        registroService.eliminar(id);
    }
}
