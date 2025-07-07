package com.abhirup.payroll.model;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ✅ Default Constructor
    public Department() {}

    // ✅ All-args Constructor
    public Department(String name) {
        this.name = name;
    }

    // ✅ Getter and Setter for id and name
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
