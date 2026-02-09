package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.InscripcionClases;
@Repository
public interface InscripcionClasesRepository extends JpaRepository<InscripcionClases,Long>{
    
}
