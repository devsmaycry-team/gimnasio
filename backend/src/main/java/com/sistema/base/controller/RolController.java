package com.sistema.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.model.Rol;
import com.sistema.base.service.RolService;
@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
	private RolService rolService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/todos")
	public List<Rol> obtenerTodos(){
		return rolService.obtenerTodos();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar/{id}")
	public Rol buscarPorId(@PathVariable Long id) {
		return rolService.obtenerPorId(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping ("/crear")
	public Rol crear (@RequestBody Rol rol) {
		return rolService.guardar(rol);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminar(@PathVariable Long id) {
		rolService.eliminar(id);
	}
}
