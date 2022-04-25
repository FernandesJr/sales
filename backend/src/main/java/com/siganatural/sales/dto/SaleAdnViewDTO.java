package com.siganatural.sales.dto;

import com.siganatural.sales.projections.SaleAdmProjection;

import java.time.Instant;

public class SaleAdnViewDTO {

    private Long id;
    private String pharmacyName;
    private String cnpj;
    private String salesmanName;
    private Instant date;
    private Double amount;
    private Long hasTicket;
    private Long hasNf;


    public SaleAdnViewDTO(){}

    public SaleAdnViewDTO(Long id, String pharmacyName, String cnpj, String salesmanName, Instant date, Double amount, Long ticket, Long nf) {
        this.id = id;
        this.pharmacyName = pharmacyName;
        this.cnpj = cnpj;
        this.salesmanName = salesmanName;
        this.date = date;
        this.amount = amount;
        this.hasTicket = ticket;
        this.hasNf = nf;
    }

    public SaleAdnViewDTO(SaleAdmProjection projetion) {
        this.id = projetion.getId();
        this.pharmacyName = projetion.getPharmacy();
        this.cnpj = projetion.getCnpj();
        this.salesmanName = projetion.getSalesman();
        this.date = projetion.getDate();
        this.amount = projetion.getAmount();
        this.hasTicket = projetion.getTicket();
        this.hasNf = projetion.getNf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(Long hasTicket) {
        this.hasTicket = hasTicket;
    }

    public Long getHasNf() {
        return hasNf;
    }

    public void setHasNf(Long hasNf) {
        this.hasNf = hasNf;
    }
}
