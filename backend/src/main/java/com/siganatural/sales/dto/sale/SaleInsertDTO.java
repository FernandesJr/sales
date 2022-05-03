package com.siganatural.sales.dto.sale;

import com.siganatural.sales.dto.product.ProductSaleDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaleInsertDTO implements Serializable {

    private String cnpj;
    private String formPay;
    private List<ProductSaleDTO> products = new ArrayList<>();

    SaleInsertDTO(){}

    public SaleInsertDTO(String cnpj, String formPay, List<ProductSaleDTO> products) {
        this.cnpj = cnpj;
        this.formPay = formPay;
        this.products = products;
    }

    public List<ProductSaleDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSaleDTO> products) {
        this.products = products;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFormPay() {
        return formPay;
    }

    public void setFormPay(String formPay) {
        this.formPay = formPay;
    }
}
