package com.siganatural.sales.dto.salesman;

import java.io.Serializable;

public class SalesmanDashDTO implements Serializable {
    private Double goal;
    private Double currentSalesAmount;
    private String percentAmount;

    public SalesmanDashDTO(){}

    public SalesmanDashDTO(Double goal, Double currentSalesAmount, String percentAmount) {
        this.goal = goal;
        this.currentSalesAmount = currentSalesAmount;
        this.percentAmount = percentAmount;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public Double getCurrentSalesAmount() {
        return currentSalesAmount;
    }

    public void setCurrentSalesAmount(Double currentSalesAmount) {
        this.currentSalesAmount = currentSalesAmount;
    }

    public String getPercentAmount() {
        return percentAmount;
    }

    public void setPercentAmount(String percentAmount) {
        this.percentAmount = percentAmount;
    }
}
