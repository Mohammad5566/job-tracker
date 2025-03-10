package com.projects.job_tracker;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(String status);
}
