package com.siganatural.sales.services;

import com.siganatural.sales.dto.SaleByIdDTO;
import com.siganatural.sales.dto.TicketDTO;
import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Ticket;
import com.siganatural.sales.repositories.SaleRepository;
import com.siganatural.sales.repositories.TicketRepository;
import com.siganatural.sales.services.exceptions.ForbiddenException;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    public SaleByIdDTO insert(TicketDTO dto){
        dtoToEntity(dto);
        return saleService.findSaleWithProductsAndTickets(dto.getSaleId());
    }

    @Transactional
    public SaleByIdDTO update(TicketDTO dto){
        Ticket ticket = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        Sale sale = saleRepository.findById(dto.getSaleId()).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        //Não permitir que tente atualizar o ticket que pertence a outra venda
        if(!sale.getTickets().contains(new Ticket(dto.getId()))){
            throw new ForbiddenException("Access denied");
        }
        dtoToEntity(dto);
        return saleService.findSaleWithProductsAndTickets(dto.getSaleId());
    }

    public void delete(Long id){
        Ticket ticket = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        repository.deleteById(id);
    }

    public void dtoToEntity(TicketDTO dto){
        Ticket ticket = new Ticket();
        ticket.setId(dto.getId());
        ticket.setDueDate(dto.getDueDate());
        ticket.setAmount(dto.getAmount());
        ticket.setPaid(dto.isPaid());
        ticket.setImage(dto.getImage());
        ticket.setSale(new Sale(dto.getSaleId()));
        repository.save(ticket);
    }
}
