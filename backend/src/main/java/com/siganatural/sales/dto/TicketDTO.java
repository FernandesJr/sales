package com.siganatural.sales.dto;

import com.siganatural.sales.entities.Ticket;

import java.time.Instant;

public class TicketDTO {

    private Long id;
    private Double amount;
    private Instant dueDate;
    private boolean pay;
    private byte[] image;

    public TicketDTO() {}

    public TicketDTO(Long id, Double amount, Instant dueDate, boolean pay) {
        this.id = id;
        this.amount = amount;
        this.dueDate = dueDate;
        this.pay = pay;
    }

    public TicketDTO(Ticket entity) {
        this.id = entity.getId();
        this.amount = entity.getAmount();
        this.dueDate = entity.getDueDate();
        this.pay = entity.isPaid();
        this.image = entity.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
