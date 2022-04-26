package com.siganatural.sales.dto;

import com.siganatural.sales.projections.ProductForSaleProjection;

public class ProductForSaleDTO {

    public String name;
    public String description;
    public Integer quantity;
    public Double price;
    public byte[] image;

    public ProductForSaleDTO(){}

    public ProductForSaleDTO(String name, String description, Integer quantity, Double price, byte[] image) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public ProductForSaleDTO(ProductForSaleProjection projection) {
        this.name = projection.getName();
        this.description = projection.getDescription();
        this.quantity = projection.getQuantity();
        this.price = projection.getPrice();
        this.image = projection.getImage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
