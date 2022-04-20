package com.siganatural.sales.dto;

import com.siganatural.sales.entities.Pharmacy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PharmacyDTO implements Serializable {

    private Long id;

    @Size(min = 3, max = 255)
    @NotBlank(message = "nome é requerido")
    private String name;

    @Size(min = 18, max = 18)
    @NotBlank(message = "cnpj é requerido")
    private String cnpj;

    @Size(min = 13, max = 13)
    private String phone;

    @Size(min = 14, max = 14)
    private String cellphone;

    @NotNull(message = "endereço é requerido")
    private AddressDTO addressDTO;

    public PharmacyDTO(){}

    public PharmacyDTO(Long id, String name, String cnpj, String phone, String cellphone, AddressDTO addressDTO) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
        this.cellphone = cellphone;
        this.addressDTO = addressDTO;
    }

    public PharmacyDTO(Pharmacy entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.phone = entity.getPhone();
        this.cellphone = entity.getCellphone();
        this.addressDTO = new AddressDTO(entity.getAddress());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
