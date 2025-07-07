package com.abhirup.payroll.model;

import jakarta.persistence.*;

@Entity
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taxType;
    private double percentage;

    // ✅ Constructors
    public Tax() {}

    public Tax(String taxType, double percentage) {
        this.taxType = taxType;
        this.percentage = percentage;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
