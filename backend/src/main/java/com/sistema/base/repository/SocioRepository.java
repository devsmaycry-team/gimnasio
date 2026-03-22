package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Socio;
import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio,Long>{
    public List<Socio> findByGimnasioId(Long id);
}
