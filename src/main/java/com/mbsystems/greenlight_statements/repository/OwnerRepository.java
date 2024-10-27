package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.JobType;
import com.mbsystems.greenlight_statements.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Owner findByName(String name);
//    List<JobType> findJobTypesByOwnerId(Long ownerId);
//    List<Invoice> findInvoicesByOwnerId(Long ownerId);

}
