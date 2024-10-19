package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.JobType;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeService {
    @Autowired
    private JobTypeRepository jobTypeRepository;

    public List<JobType> getAllJobTypes() {
        return jobTypeRepository.findAll();
    }

    public JobType saveJobType(JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    public JobType getJobTypeById(Long id) {
        return jobTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("JobType not found"));
    }
}

