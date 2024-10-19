package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository repo;





    public List<Account> getAllAccounts(){
        return repo.findAll();
    }

    public List<Account> getParentAccounts(){
        return repo.findAllByIsParent(Boolean.TRUE);
    }


    public Optional<Account> getAccountById(@PathVariable Long id){
        return Optional.of(repo.findById(id).get());
    }
    public Account saveAccount(Account account){
        return repo.save(account);
    }
    public void deleteAccount( Long id){
        repo.deleteById(id);
    }
}
