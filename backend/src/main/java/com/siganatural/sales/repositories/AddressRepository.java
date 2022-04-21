package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Address;
import com.siganatural.sales.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByPharmacy(Pharmacy pharmacy);
}
