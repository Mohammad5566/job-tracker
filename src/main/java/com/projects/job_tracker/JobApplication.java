package com.projects.job_tracker;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    private String status; // Applied, Interview, Rejected, etc.
    private LocalDate applicationDate;

    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getStatus() { return status; }
    public LocalDate getLocalDate() { return applicationDate; }
}
