package com.siganatural.sales.services;

import com.siganatural.sales.dto.SalesmanDashDTO;
import com.siganatural.sales.entities.Sale;
import com.siganatural.sales.entities.Salesman;
import com.siganatural.sales.entities.User;
import com.siganatural.sales.repositories.SaleRepository;
import com.siganatural.sales.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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

    public SalesmanDashDTO findDashboard(){
        User user = authService.userAuthenticated();
        Salesman entity = repository.findByUser(user);

        LocalDateTime currentDate = LocalDateTime.now();
        int month = currentDate.getMonthValue();
        int lastDay = currentDate.getMonth().maxLength();
        int year = currentDate.getYear();

        LocalDateTime startDate = LocalDateTime.of(year, month, 1,0,0,0);
        LocalDateTime lastDate = LocalDateTime.of(year, month, lastDay, 23, 59,0);
        List<Sale> salesByMonth = saleRepository.findByMouthSalesman(entity.getId(), startDate, lastDate);
        Double currentSalesAmount = 0D;
        for(Sale s : salesByMonth){
            currentSalesAmount += s.getAmount();
        }

        Double percent = currentSalesAmount * 100 / entity.getGoal();
        DecimalFormat fd = new DecimalFormat("0.00");
        return new SalesmanDashDTO(entity.getGoal(), currentSalesAmount, fd.format(percent));
    }
}
