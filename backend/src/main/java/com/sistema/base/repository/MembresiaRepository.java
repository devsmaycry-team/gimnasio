package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Membresia;
@Repository
public interface MembresiaRepository extends JpaRepository<Membresia,Long>{
    
}
