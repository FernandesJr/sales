package com.siganatural.sales.projections;


public interface ProductForSaleProjection {

    String getName();
    String getDescription();
    Double getPrice();
    Integer getQuantity();
    byte[] getImage();
}
