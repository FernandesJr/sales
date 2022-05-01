package com.siganatural.sales.services;

import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Salesman;
import com.siganatural.sales.entities.User;
import com.siganatural.sales.repositories.SaleRepository;
import com.siganatural.sales.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.List;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository repository;

    @Autowired
    private AuthService authService;

    @Autowired
    private SaleRepository saleRepository;

    public void findDashboard(){
        User user = authService.userAuthenticated();
        Salesman entity = repository.findByUser(user);
        LocalDateTime currentDate = LocalDateTime.now();
        int month = currentDate.getMonthValue();
        int lastDay = currentDate.getMonth().maxLength();
        int year = currentDate.getYear();
        System.out.println("Mês ATUAL: " + month);
        System.out.println("ULTIMO DIA DO MÊS: " + lastDay);
        System.out.println("Meta do vendedor: " + entity.getGoal());

        LocalDateTime startDate = LocalDateTime.of(year, month, 1,0,0,0);
        LocalDateTime lastDate = LocalDateTime.of(year, month, lastDay, 23, 59,0);

        Instant s1 = Instant.ofEpochSecond(startDate.minusHours(3).getSecond());
        Instant l1 = Instant.ofEpochSecond(lastDate.minusHours(3).getSecond());

        //List<Sale> salesByMonth = saleRepository.findByMouthSalesman(entity, s1, l1);
        List<Sale> salesByMonth = saleRepository.findByMouthSalesmanRaiz(entity.getId(), startDate, lastDate);
        System.out.println("lista vazia? " + salesByMonth.isEmpty());
        Double currentSalesAmount = 0D;
        for(Sale s : salesByMonth){
            currentSalesAmount += s.getAmount();
        }
        System.out.println("Meta do vendedor atingida: " + currentSalesAmount);
    }
}
