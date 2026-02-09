package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Clase;
@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long>{
    
}
