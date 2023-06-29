package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories("com.example.repo")
@EntityScan(basePackages = "com.example.dto")
public class InsuranceProjecApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProjecApplication.class, args);
	}

}
