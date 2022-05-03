package com.siganatural.sales.dto.product;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProductSaleDTO implements Serializable {

    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;

    public ProductSaleDTO(){}

    public ProductSaleDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductSaleDTO{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
