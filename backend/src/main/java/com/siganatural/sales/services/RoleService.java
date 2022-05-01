package com.siganatural.sales.services;

import com.siganatural.sales.dto.role.RoleDTO;
import com.siganatural.sales.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    @Transactional(readOnly = true)
    public List<RoleDTO> findRoles(){
        return repository.findAll().stream().map(r -> new RoleDTO(r)).collect(Collectors.toList());
    }

}
