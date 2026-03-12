package com.sistema.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Gimnasio;

@Repository
public interface GimnasioRepository extends JpaRepository<Gimnasio, Long>{
    Optional<Gimnasio> findByCodigoGym(String codigoGym);
}
