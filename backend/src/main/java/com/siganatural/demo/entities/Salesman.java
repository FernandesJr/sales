package com.siganatural.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salesman")
public class Salesman extends User{

    private Double goal;

    public Salesman(){}

    public Salesman(Long id, String email, String password, String firstName, String lastname, boolean active, Double goal) {
        super(id, email, password, firstName, lastname, active);
        this.goal = goal;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }
}

