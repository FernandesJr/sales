package com.siganatural.sales.resources;

import com.siganatural.sales.dto.user.UserDTO;
import com.siganatural.sales.dto.user.UserInsertDTO;
import com.siganatural.sales.dto.user.UserUpdateDTO;
import com.siganatural.sales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
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

    @PostMapping()
    public ResponseEntity<UserDTO> insertUser(@RequestBody @Valid UserInsertDTO dto){
        UserDTO userDTO = service.insert(dto);
        //Quando se cria um novo recurso deve-se devolver um status 201
        //E no head da response por convenção declara o location do recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserUpdateDTO dto, @PathVariable Long id){
        UserDTO userDTO = service.update(dto, id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Void> activeUser(@RequestParam("active") boolean active, @PathVariable Long id){
        service.activeUser(id, active);
        return ResponseEntity.noContent().build();
    }
}
