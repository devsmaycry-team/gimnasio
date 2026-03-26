package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.UserRol;
import com.sistema.base.model.Usuario;

import java.util.List;


@Repository
public interface UsuarioRolRepository extends JpaRepository <UserRol, Long>{
    List<UserRol> findByUser(Usuario user);
}
