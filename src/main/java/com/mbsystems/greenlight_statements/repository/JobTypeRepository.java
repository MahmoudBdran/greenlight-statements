package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
}
