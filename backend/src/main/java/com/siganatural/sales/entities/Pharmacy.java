package com.siganatural.sales.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cnpj;
    private String name;
    private String phone;
    private String cellphone;
    private String email;
    private boolean active;

    @OneToOne(mappedBy = "pharmacy")
    private Address address;

    @OneToMany(mappedBy = "pharmacy")
    private List<Sale> sales = new ArrayList<>();

    public Pharmacy(){}

    public Pharmacy(Long id){this.id = id;}

    public Pharmacy(Long id, String cnpj, String name, String phone , String cellphone, Address address) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.phone = phone;
        this.cellphone = cellphone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void toLower(){
        this.name = this.name.toLowerCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
