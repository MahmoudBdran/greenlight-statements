package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {


    List<Account> findAllByIsParent(Boolean isParent);
}
