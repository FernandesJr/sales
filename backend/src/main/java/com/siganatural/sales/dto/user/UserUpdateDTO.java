package com.siganatural.sales.dto.user;

import com.siganatural.sales.services.validation.UserUpdateValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO implements Serializable {

    @NotBlank(message = "nome requerido")
    private String firstName;

    @NotBlank(message = "sobrenome requerido")
    private String lastName;

    @Size(min = 6, max = 255)
    @NotBlank(message = "senha não pode ser menor que 6 caracteres")
    private String password;

    @Size(min = 6, max = 255)
    @NotBlank(message = "confirme sua nova senha, por favor.")
    private String passwordConfirm;

    private boolean active;

    public UserUpdateDTO(){}

    public UserUpdateDTO(String firstName, String lastName, String password, String passwordConfirm, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.active = active;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean passwordIsNull(){
        return password.isEmpty();
    }
}
