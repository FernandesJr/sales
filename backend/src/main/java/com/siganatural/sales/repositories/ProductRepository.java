package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
