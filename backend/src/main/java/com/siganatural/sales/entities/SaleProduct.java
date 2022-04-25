package com.siganatural.sales.entities;

import javax.persistence.*;

@Entity
@Table(name = "sale_product")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantityProduct;
    private Double priceProduct;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public SaleProduct(){}

    public SaleProduct(Long saleId, Long productId, Integer quantityOfProduct, Double priceProduct, Sale sale) {
        this.productId = productId;
        this.quantityProduct = quantityOfProduct;
        this.priceProduct = priceProduct;
        this.sale = sale;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityOfProduct) {
        this.quantityProduct = quantityOfProduct;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }
}
