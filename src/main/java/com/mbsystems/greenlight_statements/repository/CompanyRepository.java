package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByName(String name);
//    List<JobType> findJobTypesByCompanyId(Long companyId);
//    List<Invoice> findInvoicesByCompanyId(Long companyId);
}
