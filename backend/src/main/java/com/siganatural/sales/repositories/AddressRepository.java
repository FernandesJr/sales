package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
