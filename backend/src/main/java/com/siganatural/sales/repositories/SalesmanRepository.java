package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
}
