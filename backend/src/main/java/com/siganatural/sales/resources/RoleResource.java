package com.siganatural.sales.resources;

import com.siganatural.sales.dto.RoleDTO;
import com.siganatural.sales.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleResource {

    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findRoles(){
        List<RoleDTO> list = service.findRoles();
        return ResponseEntity.ok(list);
    }
}
