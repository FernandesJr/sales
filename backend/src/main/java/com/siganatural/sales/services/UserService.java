package com.siganatural.sales.services;

import com.siganatural.sales.dto.RoleDTO;
import com.siganatural.sales.dto.UserDTO;
import com.siganatural.sales.dto.UserInsertDTO;
import com.siganatural.sales.dto.UserUpdateDTO;
import com.siganatural.sales.entities.User;
import com.siganatural.sales.repositories.RoleRepository;
import com.siganatural.sales.repositories.UserRepository;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import com.siganatural.sales.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

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

    @Transactional
    public UserDTO insert(UserInsertDTO dto){
        User user = new User();
        copyDtoToEntity(dto, user);
        repository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(UserUpdateDTO dto, Long id){
        authService.isMe(id); //Somente o dono do id pode alterar seus atributos
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        if(!dto.passwordIsNull()){
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setActive(dto.isActive());
        return new UserDTO(user);
    }

    @Transactional
    public void activeUser(Long id, boolean active){
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        user.setActive(active);
    }

    public void copyDtoToEntity(UserInsertDTO dto, User user){
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); //criptografando a senha
        user.setActive(dto.isActive());
        for(RoleDTO roleDTO : dto.getRoles()){
            user.getRoles().add(roleRepository.getById(roleDTO.getId())); //Associando os roles ao user
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(user == null || !user.isActive()){
            System.out.println("Não encontrei o user " +username);
            throw new UnauthorizedException("invalid credencies or user not active");
        }
        System.out.println("Encontrei o user " +username);
        return user;
    }
}
