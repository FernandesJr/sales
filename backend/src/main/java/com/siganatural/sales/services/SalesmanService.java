package com.siganatural.sales.services;

import com.siganatural.sales.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository repository;

    @Autowired
    private AuthService authService;

    public void findDashboard(){
        int currentMonth = LocalDateTime.now().getMonthValue();
        int lastDay = LocalDateTime.now().getMonth().maxLength();
        System.out.println("Mês ATUAL: " + currentMonth);
        System.out.println("ULTIMO DIA DO MÊS: " + lastDay);
    }
}
