package com.abhirup.payroll.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_salary")
    private double baseSalary;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "tax_deducted")
    private double taxDeducted;

    @Column(name = "net_salary")
    private double netSalary;

    @Column(name = "generated_date")
    private LocalDate generatedDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double getTaxDeducted() { return taxDeducted; }
    public void setTaxDeducted(double taxDeducted) { this.taxDeducted = taxDeducted; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public LocalDate getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(LocalDate generatedDate) { this.generatedDate = generatedDate; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
