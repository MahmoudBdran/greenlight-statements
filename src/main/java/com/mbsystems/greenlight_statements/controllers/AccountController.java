package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.Account;
import com.mbsystems.greenlight_statements.service.AccountService;
import com.mbsystems.greenlight_statements.service.AccountTypeService;
import com.mbsystems.greenlight_statements.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost", "https://animated-sprinkles-d16b69.netlify.app"})

@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountTypeService accountTypeService;

    @GetMapping
    public ResponseEntity<Object> findAll(){

        Map<String, Object> data = new HashMap<>();

        data.put("accounts",  accountService.getAllAccounts());
        data.put("accountTypes",  accountTypeService.getAllAccountTypes());
        data.put("parentAccounts",  accountService.getParentAccounts());

        return AppResponse.generateResponse("all_data", HttpStatus.OK, data , true);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable Long id){

        return AppResponse.generateResponse("all_data", HttpStatus.OK, accountService.getAccountById(id) , true);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Account account){
       return AppResponse.generateResponse("تم حفط الحساب بنجاح", HttpStatus.OK, accountService.saveAccount(account) , true);
    }

    @PutMapping("/update")
    public  ResponseEntity<Object> updateAccount(@RequestBody Account account){
        return AppResponse.generateResponse("all_data", HttpStatus.OK, accountService.saveAccount(account), true);
    }



}
