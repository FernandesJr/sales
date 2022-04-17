package com.siganatural.sales.dto;

import com.siganatural.sales.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long id;

    @Email(message = "Por favor insira um email valido")
    private String email;

    @Size(min = 3, message = "nome não pode ser menor que 3 caracteres")
    @NotBlank(message = "nome requerido")
    private String firstName;

    @Size(min = 3, message = "sobrenome não pode ser menor que 3 caracteres")
    @NotBlank(message = "sobrenome requerido")
    private String lastName;

    private boolean active;
    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(){}

    public UserDTO(Long id, String email, String firstName, String lastName, boolean active) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.active = entity.isActive();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
