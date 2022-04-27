package com.siganatural.sales.services;

import com.siganatural.sales.dto.*;
import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Ticket;
import com.siganatural.sales.projections.ProductForSaleProjection;
import com.siganatural.sales.projections.SaleAdmProjection;
import com.siganatural.sales.projections.SaleByIdProjection;
import com.siganatural.sales.repositories.ProductRepository;
import com.siganatural.sales.repositories.SaleRepository;
import com.siganatural.sales.repositories.TicketRepository;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<SaleAdmViewDTO> findSalesAdm(Pageable pageable, String cnpj, String noNf, String noTicket){
        Page<SaleAdmProjection> page = repository.findSalesAdm(pageable, cnpj, noNf, noTicket);
        return page.map(s -> new SaleAdmViewDTO(s));
    }

    @Transactional(readOnly = true)
    public SaleByIdDTO findSaleWithProductsAndTickets(Long id){

        SaleByIdProjection projection = repository.findSale(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        SaleByIdDTO dto = new SaleByIdDTO(projection);
        List<Ticket> tickets = ticketRepository.findBySale(new Sale(id));
        dto.insertTickets(tickets);
        List<ProductForSaleProjection> products = productRepository.findForSale(id);
        dto.insertProducts(products);
        return dto;
    }
}
