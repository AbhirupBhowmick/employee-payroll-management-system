package com.abhirup.payroll.controller;

import com.abhirup.payroll.model.Tax;
import com.abhirup.payroll.service.TaxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxes")
@CrossOrigin(origins = "*")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    // ✅ GET all
    @GetMapping
    public List<Tax> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    // ✅ GET one
    @GetMapping("/{id}")
    public Tax getTaxById(@PathVariable Long id) {
        return taxService.getTaxById(id);
    }

    // ✅ POST
    @PostMapping
    public Tax addTax(@RequestBody Tax tax) {
        return taxService.addTax(tax);
    }

    // ✅ PUT
    @PutMapping("/{id}")
    public Tax updateTax(@PathVariable Long id, @RequestBody Tax updatedTax) {
        return taxService.updateTax(id, updatedTax);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteTax(@PathVariable Long id) {
        taxService.deleteTax(id);
    }
}
