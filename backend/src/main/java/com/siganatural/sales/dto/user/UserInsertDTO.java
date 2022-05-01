package com.siganatural.sales.dto.user;

import com.siganatural.sales.dto.user.UserDTO;
import com.siganatural.sales.services.validation.UserInsertValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@UserInsertValid //Validação do email
public class UserInsertDTO extends UserDTO {

    @Size(min = 6)
    @NotBlank(message = "senha não pode ser menor que 6 caracteres")
    private String password;

    public UserInsertDTO(){}

    public UserInsertDTO(Long id, String email, String firstName, String lastName, boolean active, String password) {
        super(id, email, firstName, lastName, active);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
