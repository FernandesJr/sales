package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query("SELECT obj FROM Pharmacy obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
    Page<Pharmacy> findAllOrByName(Pageable pageable, String name);

    Pharmacy findByCnpj(String cnpj);
}
