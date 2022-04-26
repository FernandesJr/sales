package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.projections.SaleAdmProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SaleRepository extends PagingAndSortingRepository<Sale, Long> {
    //Não extends JPA porque precisei da junção do projetion mais paginação

    @Query("SELECT obj FROM Sale obj " +
            "WHERE :cnpj = '' OR obj.pharmacy.cnpj = :cnpj")
    Page<Sale> findSalesByCnpjOrAll(Pageable pageable, String cnpj);

    //Os left join me indicam se aquela venda tem ou não algum boleto
    @Query(nativeQuery = true, value = "SELECT DISTINCT SALE.ID, PHARMACY.NAME AS PHARMACY, PHARMACY.CNPJ, " +
            "CONCAT(USER.FIRST_NAME, ' ',USER.LAST_NAME) AS SALESMAN, SALE.DATE, SALE.FORM_PAY AS PAY, SALE.AMOUNT, " +
            "TICKET.SALE_ID AS TICKET, NF.SALE_ID AS NF " +
            "FROM SALE " +
            "INNER JOIN PHARMACY ON " +
            "PHARMACY.ID = SALE.PHARMACY_ID " +
            "INNER JOIN SALESMAN ON " +
            "SALESMAN.ID = SALE.SALESMAN_ID " +
            "INNER JOIN USER ON " +
            "SALESMAN.USER_ID = USER.ID " +
            "LEFT JOIN TICKET ON " +
            "TICKET.SALE_ID = SALE.ID " +
            "LEFT JOIN NF ON " +
            "NF.SALE_ID = SALE.ID " +
            "WHERE (:cnpj = '' OR PHARMACY.CNPJ = :cnpj) AND " +
            "(:noNf = '' OR SALE.ID NOT IN (SELECT SALE_ID FROM NF)) AND " +
            "(:noTicket = '' OR SALE.ID NOT IN (SELECT SALE_ID FROM TICKET))")
    Page<SaleAdmProjection> findSalesAdm(Pageable pageable, String cnpj, String noNf, String noTicket);
}
