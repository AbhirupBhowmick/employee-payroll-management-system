package com.abhirup.payroll.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")  // Foreign key to Department table
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, String role, Department department) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.department = department;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Department getDepartment() {
        return department;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // ✅ toString() for console logging
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", department=" + (department != null ? department.getName() : "null") +
                '}';
    }
}
