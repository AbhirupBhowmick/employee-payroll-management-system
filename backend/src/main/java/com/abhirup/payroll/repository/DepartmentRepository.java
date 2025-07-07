package com.abhirup.payroll.repository;

import com.abhirup.payroll.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
