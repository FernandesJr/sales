package com.siganatural.sales.dto.sale;

import com.siganatural.sales.dto.product.ProductDTO;
import com.siganatural.sales.entities.Product;
import com.siganatural.sales.entities.Sale;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class SaleDTO {

    private Long id;
    private Long pharmacyId;
    private Long salesmanId;
    private Set<ProductDTO> productsDto = new HashSet<>();
    private Double amount;
    private Instant date;
    private String formPay;

    public SaleDTO(){}

    public SaleDTO(Long id, Long pharmacyId, Long salesmanId, Double amount, Instant date, String formPay) {
        this.id = id;
        this.pharmacyId = pharmacyId;
        this.salesmanId = salesmanId;
        this.amount = amount;
        this.date = date;
        this.formPay = formPay;
    }

    public SaleDTO(Sale entity) {
        this.id = entity.getId();
        this.pharmacyId = entity.getPharmacy().getId();
        this.salesmanId = entity.getSalesman().getId();
        this.amount = entity.getAmount();
        this.date = entity.getDate();
        this.formPay = entity.getFormPay();
        this.addProducts(entity.getProducts());
    }

    private void addProducts(Set<Product> products) {
        for(Product p : products){
            this.productsDto.add(new ProductDTO(p));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
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

    public String getFormPay() {
        return formPay;
    }

    public void setFormPay(String formPay) {
        this.formPay = formPay;
    }

    public Set<ProductDTO> getProductsDto() {
        return productsDto;
    }
}
