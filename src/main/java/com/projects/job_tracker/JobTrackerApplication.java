package com.projects.job_tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobTrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(JobTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JobTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JobApplicationRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new JobApplication("Meta", "SWE", "Applied"));
			repository.save(new JobApplication("Google", "SWE", "Applied"));
			repository.save(new JobApplication("Amazon", "SDE", "Interviewed"));
			repository.save(new JobApplication("Apple", "QA", "Applied"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			JobApplication app = repository.findByIdNumber((long) 1);
			log.info("Job Application found with findByIdNumber(1):");
			log.info("--------------------------------");
			log.info(app.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByStatus("Applied").forEach(applied -> {
				log.info(applied.toString());
			});
			log.info("");
		};
	}

}
