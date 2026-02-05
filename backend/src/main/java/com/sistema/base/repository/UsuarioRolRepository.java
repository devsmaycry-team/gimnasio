package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.UserRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository <UserRol, Long>{
    
}
