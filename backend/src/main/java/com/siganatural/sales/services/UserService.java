package com.siganatural.sales.services;

import com.siganatural.sales.dto.UserDTO;
import com.siganatural.sales.entities.User;
import com.siganatural.sales.repositories.UserRepository;
import com.siganatural.sales.services.exceptions.ForbiddenException;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<UserDTO> findUsers(){
        authService.isMain(); //Verifica se a requisição vem de um role_main
        List<User> list = repository.findAll();
        return list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        authService.validateSelfOrMain(id); //Verifica se a consulta é feita pelo o dono do id ou se é MAIN
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}
