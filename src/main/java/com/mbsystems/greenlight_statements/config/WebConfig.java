package com.mbsystems.greenlight_statements.config;

import com.mbsystems.greenlight_statements.models.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class WebConfig {

   // String [] ALLOWED_ORIGINS = {"http://localhost:3000", "https://google.com"};

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Bean
    public AuditorAware<Admin> auditorAware(){
        return new AuditorAwareImpl();
    }
}
