package com.siganatural.sales.resources;

import com.siganatural.sales.dto.PharmacyDTO;
import com.siganatural.sales.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyResource {

    @Autowired
    private PharmacyService service;

    @GetMapping
    public ResponseEntity<Page<PharmacyDTO>> findPharmacies(Pageable pageable,
                                                            @RequestParam(name = "name", defaultValue = "") String name){
        Page<PharmacyDTO> page = service.findPharmacies(pageable, name);
        return ResponseEntity.ok(page);
    }
}
