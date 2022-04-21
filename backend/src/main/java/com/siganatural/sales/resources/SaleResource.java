package com.siganatural.sales.resources;

import com.siganatural.sales.dto.SaleDTO;
import com.siganatural.sales.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleResource {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findSales(Pageable pageable,
                                                   @RequestParam(name = "cnpj", defaultValue = "") String cnpj ){
        Page<SaleDTO> page = service.findSales(pageable, cnpj);
        return ResponseEntity.ok(page);
    }
}
