package com.siganatural.sales.services;

import com.siganatural.sales.dto.NfDTO;
import com.siganatural.sales.dto.SaleByIdDTO;
import com.siganatural.sales.entities.Nf;
import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.repositories.NfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NfService {

    @Autowired
    private NfRepository repository;

    @Autowired
    private SaleService saleService;

    @Transactional(readOnly = true)
    public SaleByIdDTO insert(NfDTO dto){
        Nf nf = new Nf();
        nf.setId(dto.getId());//Para caso quando precisar atualizar
        nf.setImage(dto.getFile());
        nf.setSale(new Sale(dto.getSaleId()));
        nf = repository.save(nf);
        return saleService.findSaleWithProductsAndTickets(dto.getSaleId());
    }
}
