package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.RegistroEjercicio;
@Repository
public interface RegistroEjercicioRepository extends JpaRepository<RegistroEjercicio,Long>{
    
}
