package com.projects.job_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("http://localhost:3000")
public class JobApplicationController {
    @Autowired
    private JobApplicationRepository repository;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return repository.findAll();
    }

    @PostMapping
    public JobApplication createJob(@RequestBody JobApplication job) {
        return repository.save(job);
    }

}
