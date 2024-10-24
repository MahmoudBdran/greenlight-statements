package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.Item;
import com.mbsystems.greenlight_statements.service.InvoiceService;
import com.mbsystems.greenlight_statements.service.ItemService;
import com.mbsystems.greenlight_statements.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable Long invoiceId){
    return invoiceService.getInvoiceById(invoiceId);
    }


    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/contractor/{contractorId}")
    public List<Invoice> getInvoicesByContractor(@PathVariable Long contractorId) {
        return invoiceService.getInvoicesByContractorId(contractorId);
    }
    @GetMapping("/owner/{ownerId}")
    public List<Invoice> getInvoicesByOwner(@PathVariable Long ownerId) {
        return invoiceService.getInvoicesByOwnerId(ownerId);
    }
    @GetMapping("/company/{companyId}")
    public List<Invoice> getInvoicesByCompany(@PathVariable Long companyId) {
        return invoiceService.getInvoicesByCompanyId(companyId);
    }

}
