package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Contractor findByName(String name);
}
