package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.DTO.Response.UsuarioResponse;
import com.sistema.base.model.Usuario;
import com.sistema.base.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/todos")
    public List<UsuarioResponse> obtenerTodos(){
        return usuarioService.obtenerTodos();
    }


    @GetMapping("/buscar/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }


    @PostMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }


    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }

    @GetMapping("/gimnasio/{gimnasioId}")
    public List<UsuarioResponse> obtenerUsuariosPorGimnasio(@PathVariable Long gimnasioId) {
         return usuarioService.obtenerUsuariosPorGimnasio(gimnasioId);
    }
}