package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.JobType;
import com.mbsystems.greenlight_statements.repository.InvoiceRepository;
import com.mbsystems.greenlight_statements.repository.ItemRepository;
import com.mbsystems.greenlight_statements.repository.JobTypeRepository;
import com.mbsystems.greenlight_statements.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private JobTypeRepository jobTypeRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;



    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice saveInvoice(Invoice invoice) {

        return invoiceRepository.save(invoice);
    }
    public List<Invoice> getInvoicesByOwnerId(Long ownerId) {
        List<JobType> jobTypes = jobTypeRepository.findByOwnerId(ownerId);
        return jobTypes.stream()
                .flatMap(jobType -> invoiceRepository.findByJobTypeId(jobType.getId()).stream())
                .collect(Collectors.toList());
    }
    public List<Invoice> getInvoicesByContractorId(Long contractorId) {
        List<JobType> jobTypes = jobTypeRepository.findByContractorId(contractorId);
        return jobTypes.stream()
                .flatMap(jobType -> invoiceRepository.findByJobTypeId(jobType.getId()).stream())
                .collect(Collectors.toList());
    }
    public List<Invoice> getInvoicesByCompanyId(Long companyId) {
        List<JobType> jobTypes = jobTypeRepository.findByCompanyId(companyId);
        return jobTypes.stream()
                .flatMap(jobType -> invoiceRepository.findByJobTypeId(jobType.getId()).stream())
                .collect(Collectors.toList());
    }

    public boolean validateInvoiceInDB(Invoice invoice){
        return invoiceRepository.findById(invoice.getId()).isPresent();
    }

    public ResponseEntity<Object> getInvoiceById(Long invoiceId) {
        Map<String,Object> all_data=new HashMap<>();
        all_data.put("invoice",invoiceRepository.findById(invoiceId).orElseThrow(() -> new RuntimeException("Invoice not found")));
        all_data.put("items",itemRepository.findByInvoiceId(invoiceId));

        return AppResponse.generateResponse("all_data", HttpStatus.OK, all_data , true);
    }
}
