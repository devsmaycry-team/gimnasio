package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Mediciones;
@Repository
public interface MedicionesRepository extends JpaRepository<Mediciones,Long>{
    
}
