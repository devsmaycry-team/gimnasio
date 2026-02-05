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

import com.sistema.base.model.Persona;
import com.sistema.base.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/todos")
	public List<Persona> obtenerTodos(){
		return personaService.obtenerTodos();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar/{id}")
	public Persona buscarPorId(@PathVariable Long id) {
		return personaService.obtenerPorId(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping ("/crear")
	public Persona crear (@RequestBody Persona persona) {
		return personaService.guardar(persona);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminar(@PathVariable Long id) {
		personaService.eliminar(id);
	}
}
