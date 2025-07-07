package com.abhirup.payroll.service;

import com.abhirup.payroll.model.Tax;
import com.abhirup.payroll.repository.TaxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    public Tax getTaxById(Long id) {
        return taxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax not found"));
    }

    public Tax addTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public Tax updateTax(Long id, Tax updatedTax) {
        Tax tax = taxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax not found"));
        tax.setTaxType(updatedTax.getTaxType());
        tax.setPercentage(updatedTax.getPercentage());
        return taxRepository.save(tax);
    }

    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }
}
