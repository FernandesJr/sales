package com.siganatural.sales.services;

import com.siganatural.sales.entities.User;
import com.siganatural.sales.repositories.UserRepository;
import com.siganatural.sales.services.exceptions.ForbiddenException;
import com.siganatural.sales.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User userAuthenticated(){
        //Usuário logado no SpringSecurity
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByEmail(userName);
            return user;
        }catch (Exception e){
            throw new UnauthorizedException("Invalid user"); //Somente por segurança
        }
    }

    public void validateSelfOrMain(Long idUser){
        User user = userAuthenticated(); //Usuário logado no SpringSecurity
        if(!user.getId().equals(idUser) && !user.hasRole("ROLE_MAIN")){
            throw new ForbiddenException("Access denied");
        }
    }

    public void isMain(){
        User user = userAuthenticated(); //Usuário logado no SpringSecurity
        if(!user.hasRole("ROLE_MAIN")){
            throw new ForbiddenException("Access denied");
        }
    }

    public void isMe(Long id){
        User user = this.userAuthenticated();
        if(!user.getId().equals(id)){
            throw new ForbiddenException("Access denied");
        }
    }
}
