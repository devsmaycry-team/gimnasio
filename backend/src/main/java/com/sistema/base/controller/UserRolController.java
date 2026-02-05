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

import com.sistema.base.model.UserRol;
import com.sistema.base.service.UserRolService;
@RestController
@RequestMapping("/userrol")
public class UserRolController {
    @Autowired
	private UserRolService userRolService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/todos")
	public List<UserRol> obtenerTodos(){
		return userRolService.obtenerTodos();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar/{id}")
	public UserRol buscarPorId(@PathVariable Long id) {
		return userRolService.obtenerPorId(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping ("/crear")
	public UserRol crear (@RequestBody UserRol userRol) {
		return userRolService.guardar(userRol);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminar(@PathVariable Long id) {
		userRolService.eliminar(id);
	}
}
