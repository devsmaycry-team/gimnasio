package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.model.UserRol;
import com.sistema.base.repository.UsuarioRolRepository;
import com.sistema.base.service.UserRolService;
@Service
public class UsuarioRolServiceImplementation implements UserRolService{
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public List<UserRol> obtenerTodos() {
        return usuarioRolRepository.findAll();
    }

    @Override
    public UserRol obtenerPorId(Long id) {
        return usuarioRolRepository.findById(id).orElse(null);
    }

    @Override
    public UserRol guardar(UserRol userRol) {
        return usuarioRolRepository.save(userRol);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRolRepository.deleteById(id);
    }
}
