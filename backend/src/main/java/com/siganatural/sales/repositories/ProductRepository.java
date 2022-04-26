package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Product;
import com.siganatural.sales.projections.ProductForSaleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActive(boolean active);

    @Query(nativeQuery = true, value =
            "SELECT P.NAME, P.DESCRIPTION, P.IMAGE, " +
            "SALE_PRODUCT.QUANTITY_PRODUCT AS QUANTITY, SALE_PRODUCT.PRICE_PRODUCT AS PRICE " +
            "FROM PRODUCT AS P " +
            "INNER JOIN SALE_PRODUCT ON " +
            "SALE_PRODUCT.PRODUCT_ID = P.ID " +
            "INNER JOIN SALE ON " +
            "SALE_PRODUCT.SALE_ID = SALE.ID " +
            "WHERE SALE.ID = :idSale")
    List<ProductForSaleProjection> findForSale(Long idSale);
}
