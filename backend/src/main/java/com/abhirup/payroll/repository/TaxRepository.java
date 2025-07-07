package com.abhirup.payroll.repository;

import com.abhirup.payroll.model.Tax; // ✅ This line was missing
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
