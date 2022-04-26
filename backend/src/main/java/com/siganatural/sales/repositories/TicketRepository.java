package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findBySale(Sale sale);
}
