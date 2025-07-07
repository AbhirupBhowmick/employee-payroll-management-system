package com.abhirup.payroll.repository;

import com.abhirup.payroll.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
