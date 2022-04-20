package com.siganatural.sales.dto;

import com.siganatural.sales.entities.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AddressDTO implements Serializable {

    private Long id;

    @Size(min = 3, max = 255)
    @NotBlank(message = "cidade é requerido")
    private String city;

    @Size(min = 3, max = 255)
    @NotBlank(message = "bairro é requerido")
    private String district;

    @Size(min = 1, max = 255)
    @NotBlank(message = "rua é requerido")
    private String street;

    @NotNull
    private Integer number;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String city, String district, String street, Integer number) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.city = entity.getCity();
        this.district = entity.getDistrict();
        this.street = entity.getStreet();
        this.number = entity.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
