package com.siganatural.sales.resources;

import com.siganatural.sales.dto.nf.NfDTO;
import com.siganatural.sales.dto.sale.SaleByIdDTO;
import com.siganatural.sales.services.NfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nfs")
public class NfResource {

    @Autowired
    private NfService service;

    @PostMapping
    public ResponseEntity<SaleByIdDTO> insert(@RequestBody NfDTO nfDTO){
        SaleByIdDTO saleDto = service.insert(nfDTO);
        return ResponseEntity.ok(saleDto);
    }
}
