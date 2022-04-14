package com.siganatural.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "salesman")
public class Salesman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double goal;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Salesman(){}

    public Salesman(Long id, String email, String password, String firstName, String lastname, boolean active, Double goal) {
        //super(id, email, password, firstName, lastname, active);
        this.goal = goal;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

