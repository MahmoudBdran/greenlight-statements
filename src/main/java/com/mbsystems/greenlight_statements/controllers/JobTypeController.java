package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.JobType;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobtypes")
public class JobTypeController {
    @Autowired
    private JobTypeService jobTypeService;

    @GetMapping
    public List<JobType> getAllJobTypes() {
        return jobTypeService.getAllJobTypes();
    }

    @PostMapping
    public JobType addJobType(@RequestBody JobType jobType) {
        return jobTypeService.saveJobType(jobType);
    }

    @GetMapping("/{id}")
    public JobType getJobTypeById(@PathVariable Long id) {
        return jobTypeService.getJobTypeById(id);
    }
}
