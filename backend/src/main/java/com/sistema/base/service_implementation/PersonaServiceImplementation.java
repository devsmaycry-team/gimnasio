package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.model.Persona;
import com.sistema.base.repository.PersonaRepository;
import com.sistema.base.service.PersonaService;

@Service
public class PersonaServiceImplementation implements PersonaService{
	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<Persona> obtenerTodos(){
		return personaRepository.findAll();
	}
	@Override
	public Persona obtenerPorId(Long id) {
		return personaRepository.findById(id).orElse(null);

	}
	@Override
	public Persona guardar(Persona persona) {
		return personaRepository.save(persona);
	}
	@Override
	public void eliminar(Long id) {
		personaRepository.deleteById(id);
	}
}
