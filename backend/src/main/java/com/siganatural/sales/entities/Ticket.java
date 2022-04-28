package com.siganatural.sales.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Armazenar na db sem Time zone, permanece o meridiano de greenwich
    private Instant dueDate;

    private boolean paid;

    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Ticket(){}

    public Ticket(Long id){this.id = id;}

    public Ticket(Long id, Double amount, Instant dueDate, boolean paid, byte[] image, Sale sale) {
        this.id = id;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = paid;
        this.image = image;
        this.sale = sale;
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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId().equals(ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
