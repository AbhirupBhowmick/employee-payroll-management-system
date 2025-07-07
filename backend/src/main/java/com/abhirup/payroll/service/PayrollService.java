package com.abhirup.payroll.service;

import com.abhirup.payroll.model.Employee;
import com.abhirup.payroll.model.Payroll;
import com.abhirup.payroll.repository.EmployeeRepository;
import com.abhirup.payroll.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepository;
    private final EmployeeRepository employeeRepository;

    public PayrollService(PayrollRepository payrollRepository, EmployeeRepository employeeRepository) {
        this.payrollRepository = payrollRepository;
        this.employeeRepository = employeeRepository;
    }

    // ✅ Generate payroll for an employee
    public Payroll generatePayroll(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setBaseSalary(50000);      // Example base salary
        payroll.setBonus(5000);            // Example bonus
        payroll.setTaxDeducted(5000);      // Example tax
        payroll.setNetSalary(50000);       // base + bonus - tax
        payroll.setGeneratedDate(LocalDate.now());

        return payrollRepository.save(payroll);
    }

    // ✅ Get all payrolls
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    // ✅ Get payroll by ID
    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    // ✅ Update payroll
    public Payroll updatePayroll(Long id, Payroll updatedPayroll) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        payroll.setBaseSalary(updatedPayroll.getBaseSalary());
        payroll.setBonus(updatedPayroll.getBonus());
        payroll.setTaxDeducted(updatedPayroll.getTaxDeducted());
        payroll.setNetSalary(updatedPayroll.getNetSalary());
        payroll.setGeneratedDate(updatedPayroll.getGeneratedDate());

        return payrollRepository.save(payroll);
    }

    // ✅ Delete payroll
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
