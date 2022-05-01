package com.siganatural.sales.resources;

import com.siganatural.sales.dto.pharmacy.PharmacyDTO;
import com.siganatural.sales.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyDTO> findPharmacy(@PathVariable Long id){
        PharmacyDTO dto = service.findPharmacy(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PharmacyDTO> insert(@RequestBody @Valid PharmacyDTO dto){
        PharmacyDTO pharmacyDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(pharmacyDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pharmacyDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PharmacyDTO> update(@RequestBody @Valid PharmacyDTO dto, @PathVariable Long id){
        PharmacyDTO pharmacyDTO = service.update(dto, id);
        return ResponseEntity.ok(pharmacyDTO);
    }
}
