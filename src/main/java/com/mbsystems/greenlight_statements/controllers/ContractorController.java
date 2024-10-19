package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contractors")
public class ContractorController {
    @Autowired
    private ContractorService contractorService;

    @GetMapping
    public List<Contractor> getAllContractors() {
        return contractorService.getAllContractors();
    }

    @PostMapping
    public Contractor addContractor(@RequestBody Contractor contractor) {
        return contractorService.saveContractor(contractor);
    }

    @GetMapping("/{id}")
    public Contractor getContractorById(@PathVariable Long id) {
        return contractorService.getContractorById(id);
    }
}
