package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractorRepository extends JpaRepository<Contractor,Long> {
    Contractor findByName(String name);
//    List<JobType> findJobTypesByContractorId(Long contractorId);
//    List<Invoice> findInvoicesByContractorId(Long contractorId);
}
