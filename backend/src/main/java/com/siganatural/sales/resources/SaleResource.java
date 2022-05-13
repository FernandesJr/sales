package com.siganatural.sales.resources;

import com.siganatural.sales.dto.product.ProductSaleDTO;
import com.siganatural.sales.dto.sale.SaleAdmViewDTO;
import com.siganatural.sales.dto.sale.SaleByIdDTO;
import com.siganatural.sales.dto.sale.SaleInsertDTO;
import com.siganatural.sales.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody SaleInsertDTO dto){
        service.insert(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.verificationDelete(id);
        return ResponseEntity.noContent().build();
    }
}
