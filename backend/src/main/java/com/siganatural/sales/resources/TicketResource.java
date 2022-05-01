package com.siganatural.sales.resources;

import com.siganatural.sales.dto.sale.SaleByIdDTO;
import com.siganatural.sales.dto.ticket.TicketDTO;
import com.siganatural.sales.dto.ticket.TicketNoPaidDTO;
import com.siganatural.sales.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketResource {

    @Autowired
    private TicketService service;

    @PostMapping
    public ResponseEntity<SaleByIdDTO> insert(@RequestBody @Valid TicketDTO dto){
        SaleByIdDTO sale = service.insert(dto);
        return ResponseEntity.ok(sale);
    }

    @PutMapping
    public ResponseEntity<SaleByIdDTO> update(@RequestBody @Valid TicketDTO dto){
        SaleByIdDTO sale = service.update(dto);
        return ResponseEntity.ok(sale);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/unpaid")
    public ResponseEntity<Page<TicketNoPaidDTO>> noPaid(Pageable pageable,
                                                        @RequestParam(name = "cnpj", defaultValue = "") String cnpj,
                                                        @RequestParam(name = "saleId", defaultValue = "0") Long saleId){
        Page<TicketNoPaidDTO> page = service.findTicketsNoPaid(pageable, cnpj, saleId);
        return ResponseEntity.ok(page);
    }

}
