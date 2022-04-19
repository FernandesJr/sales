package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActive(boolean active);
}
