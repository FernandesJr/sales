package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Ticket;
import com.siganatural.sales.projections.TicketNoPaidProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

    List<Ticket> findBySale(Sale sale);

    @Query(nativeQuery = true, value =
            "SELECT TICKET.ID, TICKET.AMOUNT, TICKET.DUE_DATE AS DUE, SALE.ID AS SALE, " +
            "PHARMACY.NAME AS PHARMACY, PHARMACY.CNPJ " +
            "FROM TICKET " +
            "INNER JOIN SALE ON " +
            "SALE.ID = TICKET.SALE_ID " +
            "INNER JOIN PHARMACY ON " +
            "SALE.PHARMACY_ID = PHARMACY.ID " +
            "WHERE (TICKET.PAID = FALSE) AND " +
            "(:cnpj = '' OR PHARMACY.CNPJ = :cnpj) AND " +
            "(:saleId = 0 OR SALE.ID = :saleId)")
    Page<TicketNoPaidProjection> findByNoPaid(Pageable pageable, String cnpj, Long saleId);
}
