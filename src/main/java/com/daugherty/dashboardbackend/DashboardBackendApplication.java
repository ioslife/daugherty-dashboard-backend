package com.daugherty.dashboardbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DashboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardBackendApplication.class, args);
	}

}
