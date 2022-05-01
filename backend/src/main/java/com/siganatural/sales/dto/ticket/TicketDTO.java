package com.siganatural.sales.dto.ticket;

import com.siganatural.sales.entities.Ticket;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class TicketDTO {

    private Long id;

    @NotNull(message = "valor é requerido")
    private Double amount;

    @FutureOrPresent(message = "Vencimento não pode ser no passado")
    @NotNull(message = "vencimento é requerido")
    private Instant dueDate;

    private boolean paid;

    private byte[] image;

    @NotNull
    private Long saleId;

    public TicketDTO() {}

    public TicketDTO(Long id, Double amount, Instant dueDate, boolean paid) {
        this.id = id;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = paid;
    }

    public TicketDTO(Ticket entity) {
        this.id = entity.getId();
        this.amount = entity.getAmount();
        this.dueDate = entity.getDueDate();
        this.paid = entity.isPaid();
        this.image = entity.getImage();
        this.saleId = entity.getSale().getId();
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
