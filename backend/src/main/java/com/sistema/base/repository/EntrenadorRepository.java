package com.sistema.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Entrenador;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador,Long>{
    List<Entrenador> findByGimnasioId(Long id);
}
