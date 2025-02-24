package com.siganatural.sales.entities;

import com.siganatural.sales.dto.address.AddressDTO;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String district;
    private String street;
    private Integer number;

    @OneToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    public Address(){}

    public Address(Long id, String city, String district, String street, Integer number) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    public Address(AddressDTO dto) {
        this.id = dto.getId();
        this.city = dto.getCity();
        this.district = dto.getDistrict();
        this.street = dto.getStreet();
        this.number = dto.getNumber();
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
