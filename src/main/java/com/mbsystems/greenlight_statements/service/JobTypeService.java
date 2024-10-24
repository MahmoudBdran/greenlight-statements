package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.JobType;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.repository.InvoiceRepository;
import com.mbsystems.greenlight_statements.repository.JobTypeRepository;
import com.mbsystems.greenlight_statements.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobTypeService {
    @Autowired
    private JobTypeRepository jobTypeRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<JobType> getAllJobTypes() {

        return jobTypeRepository.findAll();
    }

    public JobType saveJobType(JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    public ResponseEntity<Object> getJobTypeById(Long id) {
            Map<String,Object> all_data=new HashMap<>();
            all_data.put("jobtype",jobTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("JobType not found")));
            all_data.put("invoice",invoiceRepository.findByJobTypeId(id));

            return AppResponse.generateResponse("all_data", HttpStatus.OK, all_data , true);
    }
}

