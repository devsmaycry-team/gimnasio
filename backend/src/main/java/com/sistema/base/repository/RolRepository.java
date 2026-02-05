package com.sistema.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Rol;

@Repository
public interface RolRepository extends JpaRepository <Rol, Long>{
    Optional<Rol> findByCargo(String tipo);
}
