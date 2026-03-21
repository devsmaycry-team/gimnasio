package com.sistema.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.base.model.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan,Long>{
    List<Plan> findByGimnasioId(Long id);
}
