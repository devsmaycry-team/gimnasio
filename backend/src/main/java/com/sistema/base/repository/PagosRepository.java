package com.sistema.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Pagos;
@Repository
public interface PagosRepository extends JpaRepository<Pagos,Long>{
    
}
