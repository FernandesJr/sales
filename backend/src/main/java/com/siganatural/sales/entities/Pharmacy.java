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
    private String cnpj;
    private String name;
    private String phone;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "pharmacy")
    private Address address;

    @OneToMany(mappedBy = "pharmacy")
    private List<Sale> sales = new ArrayList<>();

    public Pharmacy(){}

    public Pharmacy(Long id, String cnpj, String name, String phone, Address address) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.phone = phone;
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
}
