package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
    void deleteBySale(Sale sale);
}
