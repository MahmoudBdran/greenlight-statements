package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.Company;
import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
    List<JobType> findByOwnerId(Long ownerId);
    List<JobType> findByContractorId(Long contractorId);
    List<JobType> findByCompanyId(Long CompanyId);
}
