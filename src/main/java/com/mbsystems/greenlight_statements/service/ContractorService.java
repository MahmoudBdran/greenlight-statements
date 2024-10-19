package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.enums.StartBalanceStatusEnum;
import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.AccountType;
import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.repository.AccountRepository;
import com.mbsystems.greenlight_statements.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContractorService {
    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    public Contractor saveContractor(Contractor contractor) {
        if(validateContractorInDB(contractor)){
            contractor.setAccount(new Account(initiateAccountForContractor(contractor).getId()));
            return contractorRepository.save(contractor);
        }else{
           return null;
        }

    }



    public Contractor getContractorById(Long id) {
        return contractorRepository.findById(id).orElseThrow(() -> new RuntimeException("Contractor not found"));
    }

    public boolean validateContractorInDB(Contractor contractor){
        if(contractorRepository.findByName(contractor.getName())==null){
            return true;
        }else{
            return false;
        }
    }


    public Account initiateAccountForContractor(Contractor contractor){
        Account account = new Account();
        account.setName(contractor.getName());
        account.setStartBalanceStatus(contractor.getStartBalanceStatus());

        //start Balance status , Start Balance
        if(contractor.getStartBalanceStatus()== StartBalanceStatusEnum.CREDIT.getValue()){
            //credit
            account.setStartBalance(contractor.getStartBalance().negate());
        }else if(contractor.getStartBalanceStatus()==StartBalanceStatusEnum.DEBIT.getValue()){
            account.setStartBalance(contractor.getStartBalance());
            if(account.getStartBalance().compareTo(BigDecimal.ZERO)<0){
                account.setStartBalance(account.getStartBalance().negate());
            }
        }else if(contractor.getStartBalanceStatus()==StartBalanceStatusEnum.BALANCED.getValue()){
            account.setStartBalance(BigDecimal.ZERO);
        }else{
            account.setStartBalanceStatus(StartBalanceStatusEnum.BALANCED.getValue());
            account.setStartBalance(BigDecimal.ZERO);
        }


        account.setCurrentBalance(contractor.getStartBalance());
       // account.setParentAccount(new Account(adminPanelSettingsRepo.findAll().get(0).getCustomerParentAccountNumber()));
        account.setNotes(contractor.getNotes());
        account.setIsParent(false);
        AccountType accountType=new AccountType();
        accountType.setId(3L);
        account.setAccountType(accountType);
        account.setActive(true);

        return accountRepository.save(account);

    }
}

