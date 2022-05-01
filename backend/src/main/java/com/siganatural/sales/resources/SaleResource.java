package com.siganatural.sales.resources;

import com.siganatural.sales.dto.sale.SaleAdmViewDTO;
import com.siganatural.sales.dto.sale.SaleByIdDTO;
import com.siganatural.sales.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleResource {

    @Autowired
    private SaleService service;

    @GetMapping("/adm")
    public ResponseEntity<Page<SaleAdmViewDTO>> findSalesAdm(Pageable pageable,
                                                             @RequestParam(name = "cnpj", defaultValue = "") String cnpj,
                                                             @RequestParam(name = "noNf", defaultValue = "") String noNf,
                                                             @RequestParam(name = "noTicket", defaultValue = "") String noTicket){
        Page<SaleAdmViewDTO> page = service.findSalesAdm(pageable, cnpj, noNf, noTicket);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleByIdDTO> findSale(@PathVariable Long id){
        SaleByIdDTO sale = service.findSaleWithProductsAndTickets(id);
        return ResponseEntity.ok(sale);
    }
}
