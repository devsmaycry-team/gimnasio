package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Rutina;
@Repository
public interface RutinaRepository extends JpaRepository<Rutina,Long>{
    
}
