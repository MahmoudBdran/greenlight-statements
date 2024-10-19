package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
}
