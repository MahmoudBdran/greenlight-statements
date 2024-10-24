package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.enums.StartBalanceStatusEnum;
import com.mbsystems.greenlight_statements.models.*;
import com.mbsystems.greenlight_statements.repository.AccountRepository;
import com.mbsystems.greenlight_statements.repository.CompanyRepository;
import com.mbsystems.greenlight_statements.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private JobTypeRepository jobTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AccountRepository accountRepository;


    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company saveCompany(Company company) {
       // return companyRepository.save(company);
        if(validateCompanyInDB(company)){
            company.setAccount(new Account(initiateAccountForCompany(company).getId()));
            return companyRepository.save(company);
        }else{
            return null;
        }

    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }
    public boolean validateCompanyInDB(Company company){
        if(companyRepository.findByName(company.getName())==null){
            return true;
        }else{
            return false;
        }
    }


    public Account initiateAccountForCompany(Company  company){
        Account account = new Account();
        account.setName(company.getName());
        account.setStartBalanceStatus(company.getStartBalanceStatus());

        //start Balance status , Start Balance
        if(company.getStartBalanceStatus()== StartBalanceStatusEnum.CREDIT.getValue()){
            //credit
            account.setStartBalance(company.getStartBalance().negate());
        }else if(company.getStartBalanceStatus()==StartBalanceStatusEnum.DEBIT.getValue()){
            account.setStartBalance(company.getStartBalance());
            if(account.getStartBalance().compareTo(BigDecimal.ZERO)<0){
                account.setStartBalance(account.getStartBalance().negate());
            }
        }else if(company.getStartBalanceStatus()==StartBalanceStatusEnum.BALANCED.getValue()){
            account.setStartBalance(BigDecimal.ZERO);
        }else{
            account.setStartBalanceStatus(StartBalanceStatusEnum.BALANCED.getValue());
            account.setStartBalance(BigDecimal.ZERO);
        }


        account.setCurrentBalance(company.getStartBalance());
        // account.setParentAccount(new Account(adminPanelSettingsRepo.findAll().get(0).getCustomerParentAccountNumber()));
        account.setNotes(company.getNotes());
        account.setIsParent(false);
        AccountType accountType=new AccountType();
        accountType.setId(3L);
        account.setAccountType(accountType);
        account.setActive(true);

        return accountRepository.save(account);

    }
    public List<JobType> getJobTypesByCompanyId(Long companyId) {
        return jobTypeRepository.findByCompanyId(companyId);
    }

}

