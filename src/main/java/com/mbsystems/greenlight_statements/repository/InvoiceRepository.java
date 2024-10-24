package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    List<Invoice> findByJobTypeId(Long jobTypeId);

}
