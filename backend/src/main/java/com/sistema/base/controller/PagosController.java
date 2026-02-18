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

import com.sistema.base.DTO.Request.PagosRequest;
import com.sistema.base.DTO.Response.PagosResponse;
import com.sistema.base.service.PagosService;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private PagosService pagosService;

    @GetMapping
    public List<PagosResponse> obtenerTodos() {
        return pagosService.obtenertodos();
    }

    @GetMapping("/{id}")
    public PagosResponse obtenerPorId(@PathVariable Long id) {
        return pagosService.obtenerPorId(id);
    }

    @PostMapping
    public PagosResponse guardar(@RequestBody PagosRequest dto) {
        return pagosService.guardar(dto);
    }

    @PutMapping("/{id}")
    public PagosResponse editar(@PathVariable Long id, @RequestBody PagosRequest dto) {
        return pagosService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagosService.eliminar(id);
    }
}
