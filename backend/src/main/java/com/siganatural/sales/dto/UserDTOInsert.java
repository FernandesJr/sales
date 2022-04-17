package com.siganatural.sales.dto;

public class UserDTOInsert extends UserDTO{

    private String password;

    public UserDTOInsert(){}

    public UserDTOInsert(Long id, String email, String firstName, String lastName, boolean active, String password) {
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
