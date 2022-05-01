package com.siganatural.sales.dto.ticket;

import com.siganatural.sales.projections.TicketNoPaidProjection;

import java.io.Serializable;
import java.time.Instant;

public class TicketNoPaidDTO implements Serializable {

    private Long id;
    private String cnpj;
    private String pharmacy;
    private Instant dueDate;
    private Double amount;
    private Long saleId;

    public TicketNoPaidDTO(){}

    public TicketNoPaidDTO(Long id, String cnpj, String pharmacy, Instant dueDate, Double amount, Long saleId) {
        this.id = id;
        this.cnpj = cnpj;
        this.pharmacy = pharmacy;
        this.dueDate = dueDate;
        this.amount = amount;
        this.saleId = saleId;
    }

    public TicketNoPaidDTO(TicketNoPaidProjection projection) {
        this.id = projection.getId();
        this.cnpj = projection.getCnpj();
        this.pharmacy = projection.getPharmacy();
        this.dueDate = projection.getDue();
        this.amount = projection.getAmount();
        this.saleId = projection.getSale();
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

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
