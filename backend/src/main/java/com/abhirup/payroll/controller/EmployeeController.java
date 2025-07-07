package com.abhirup.payroll.controller;

import com.abhirup.payroll.model.Employee;
import com.abhirup.payroll.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // ✅ POST add employee (with console log for debug)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("Received: " + employee);  // Logs the employee data
        return employeeService.addEmployee(employee);
    }

    // ✅ DELETE employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
