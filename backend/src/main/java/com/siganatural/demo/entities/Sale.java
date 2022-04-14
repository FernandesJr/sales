package com.siganatural.demo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String formPay;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Armazenar na db sem Time zone, permanece o meridiano de greenwich
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name = "salesman_id")
    private Salesman salesman;

    //No many to many não tem a possibilidade de adicionar outro campo na tabela, assim crie um objeto que representa o relacionamento
    @Transient //Informando ao Hibernate que não quero persistir esse atributo
    private List<Product> products = new ArrayList<>();

    @OneToOne(mappedBy = "sale")
    private SaleProduct saleProduct;

    @OneToMany(mappedBy = "sale")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToOne(mappedBy = "sale")
    private Nf nf;


    public Sale(){}

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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    /*public List<Product> getProducts() {
        return products;
    }*/
}
