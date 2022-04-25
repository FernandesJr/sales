package com.siganatural.sales.services;

import com.siganatural.sales.dto.SaleAdnViewDTO;
import com.siganatural.sales.dto.SaleDTO;
import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.projections.SaleAdmProjection;
import com.siganatural.sales.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findSales(Pageable pageable, String cnpj){
        Page<Sale> page = repository.findSalesByCnpjOrAll(pageable, cnpj);
        return page.map(s -> new SaleDTO(s));
    }

    @Transactional(readOnly = true)
    public Page<SaleAdnViewDTO> findSalesAdm(Pageable pageable, String cnpj){
        Page<SaleAdmProjection> page = repository.findSalesAdm(pageable, cnpj);
        return page.map(s -> new SaleAdnViewDTO(s));
    }
}
