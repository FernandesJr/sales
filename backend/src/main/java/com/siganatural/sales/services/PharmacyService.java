package com.siganatural.sales.services;

import com.siganatural.sales.dto.PharmacyDTO;
import com.siganatural.sales.entities.Pharmacy;
import com.siganatural.sales.repositories.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository repository;

    @Transactional(readOnly = true)
    public Page<PharmacyDTO> findPharmacies(Pageable pageable, String name){
        Page<Pharmacy> page = repository.findAllOrByName(pageable, name);
        return page.map(p -> new PharmacyDTO(p));
    }
}
