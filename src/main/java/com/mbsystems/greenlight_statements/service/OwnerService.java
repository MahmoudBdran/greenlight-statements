package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.enums.StartBalanceStatusEnum;
import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.models.AccountType;
import com.mbsystems.greenlight_statements.models.Contractor;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.repository.AccountRepository;
import com.mbsystems.greenlight_statements.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner saveOwner(Owner owner) {
        //return ownerRepository.save(owner);
        if(validateOwnerInDB(owner)){
            owner.setAccount(new Account(initiateAccountForContractor(owner).getId()));
            return ownerRepository.save(owner);
        }else{
            return null;
        }
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
    }



    public boolean validateOwnerInDB(Owner owner){
        if(ownerRepository.findByName(owner.getName())==null){
            return true;
        }else{
            return false;
        }
    }


    public Account initiateAccountForContractor(Owner owner){
        Account account = new Account();
        account.setName(owner.getName());
        account.setStartBalanceStatus(owner.getStartBalanceStatus());

        //start Balance status , Start Balance
        if(owner.getStartBalanceStatus()== StartBalanceStatusEnum.CREDIT.getValue()){
            //credit
            account.setStartBalance(owner.getStartBalance().negate());
        }else if(owner.getStartBalanceStatus()==StartBalanceStatusEnum.DEBIT.getValue()){
            account.setStartBalance(owner.getStartBalance());
            if(account.getStartBalance().compareTo(BigDecimal.ZERO)<0){
                account.setStartBalance(account.getStartBalance().negate());
            }
        }else if(owner.getStartBalanceStatus()==StartBalanceStatusEnum.BALANCED.getValue()){
            account.setStartBalance(BigDecimal.ZERO);
        }else{
            account.setStartBalanceStatus(StartBalanceStatusEnum.BALANCED.getValue());
            account.setStartBalance(BigDecimal.ZERO);
        }


        account.setCurrentBalance(owner.getStartBalance());
        // account.setParentAccount(new Account(adminPanelSettingsRepo.findAll().get(0).getCustomerParentAccountNumber()));
        account.setNotes(owner.getNotes());
        account.setIsParent(false);
        AccountType accountType=new AccountType();
        accountType.setId(3L);
        account.setAccountType(accountType);
        account.setActive(true);

        return accountRepository.save(account);

    }
}

