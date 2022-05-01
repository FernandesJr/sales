package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Salesman;
import com.siganatural.sales.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
    Salesman findByUser(User user);
}
