package com.siganatural.sales.services;

import com.siganatural.sales.dto.address.AddressDTO;
import com.siganatural.sales.entities.Address;
import com.siganatural.sales.entities.Pharmacy;
import com.siganatural.sales.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    //Não inseri o Transactional para preservar a transação do método na classe PharmacyService
    public Address insert(AddressDTO dto, Long idPharmacy){
        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setPharmacy(new Pharmacy(idPharmacy));
        return repository.save(entity);
    }

    public Address update(AddressDTO dto, Pharmacy pharmacy){
        Address entity = repository.findByPharmacy(pharmacy);
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        return repository.save(entity);
    }
}
