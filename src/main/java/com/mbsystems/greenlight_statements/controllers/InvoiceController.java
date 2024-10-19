package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/contractor/{contractorId}")
    public List<Invoice> getInvoicesByContractor(@PathVariable Long contractorId) {
        return invoiceService.getInvoicesByContractor(contractorId);
    }
}
