package com.siganatural.sales.resources;

import com.siganatural.sales.dto.salesman.SalesmanDashDTO;
import com.siganatural.sales.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salesman")
public class SalesmanResource {

    @Autowired
    private SalesmanService service;

    @GetMapping
    public ResponseEntity<SalesmanDashDTO> dashboard(){
        SalesmanDashDTO dto = service.findDashboard();
        return ResponseEntity.ok(dto);
    }
}
