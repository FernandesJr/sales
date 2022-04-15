package com.siganatural.sales.resources;

import com.siganatural.sales.dto.UserDTO;
import com.siganatural.sales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findUsers(){
        List<UserDTO> list = service.findUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Long id){
        UserDTO userDTO = service.findById(id);
        return ResponseEntity.ok(userDTO);
    }
}
