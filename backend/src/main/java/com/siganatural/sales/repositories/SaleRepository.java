package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj " +
            "WHERE :cnpj = '' OR obj.pharmacy.cnpj = :cnpj")
    Page<Sale> findSalesByCnpjOrAll(Pageable pageable, String cnpj);
}
