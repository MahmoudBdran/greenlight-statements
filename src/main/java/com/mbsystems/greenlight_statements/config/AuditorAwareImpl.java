package com.mbsystems.greenlight_statements.config;

import com.mbsystems.greenlight_statements.models.Admin;
import com.mbsystems.greenlight_statements.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Optional<Admin> getCurrentAuditor() {


        return Optional.of( adminRepository.findById(1)).get();
    }
}
