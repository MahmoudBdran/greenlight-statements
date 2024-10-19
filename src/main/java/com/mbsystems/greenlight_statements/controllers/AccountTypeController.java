package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.service.AccountTypeService;
import com.mbsystems.greenlight_statements.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost", "https://animated-sprinkles-d16b69.netlify.app"})

@RequestMapping("/account_types")
public class AccountTypeController {

    @Autowired
    AccountTypeService service;

    @GetMapping
    public ResponseEntity<Object> getAllAccountTypes(){
        return AppResponse.generateResponse("all_data", HttpStatus.OK, service.getAllAccountTypes() , true);
    }

}
