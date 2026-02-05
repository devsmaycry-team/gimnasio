package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.model.Rol;
import com.sistema.base.repository.RolRepository;
import com.sistema.base.service.RolService;

@Service
public class RolServiceImplementation implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    @Override
    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}