package com.siganatural.sales.services;

import com.siganatural.sales.dto.PharmacyDTO;
import com.siganatural.sales.entities.Address;
import com.siganatural.sales.entities.Pharmacy;
import com.siganatural.sales.repositories.PharmacyRepository;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository repository;

    @Autowired
    private AddressService addressService;



    @Transactional(readOnly = true)
    public Page<PharmacyDTO> findPharmacies(Pageable pageable, String name){
        Page<Pharmacy> page = repository.findAllOrByName(pageable, name);
        return page.map(p -> new PharmacyDTO(p));
    }

    @Transactional(readOnly = true)
    public PharmacyDTO findPharmacy(Long id){
        Pharmacy entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PharmacyDTO(entity);
    }

    @Transactional
    public PharmacyDTO insert(PharmacyDTO dto){
        Pharmacy entity = new Pharmacy();
        entity.setCnpj(dto.getCnpj());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setCellphone(dto.getCellphone());
        entity.toLower(); //Para salvar os campos String em letras minúsculas, influência na busca por name, Letras maiúsculas tem maior precedência
        entity = repository.save(entity);
        Address address = addressService.insert(dto.getAddressDTO(), entity.getId());
        entity.setAddress(address);
        return new PharmacyDTO(entity);
    }
}
