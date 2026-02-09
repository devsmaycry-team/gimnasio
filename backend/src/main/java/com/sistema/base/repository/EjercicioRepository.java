package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Ejercicio;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio,Long>{
    
}
