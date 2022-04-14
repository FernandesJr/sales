package com.siganatural.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "nf")
public class Nf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Nf(){}

    public Nf(Long id, byte[] image, Sale sale) {
        this.id = id;
        this.image = image;
        //this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
     /*
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }*/
}
