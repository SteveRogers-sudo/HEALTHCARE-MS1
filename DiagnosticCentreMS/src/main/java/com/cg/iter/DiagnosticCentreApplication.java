package com.cg.iter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class DiagnosticCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosticCentreApplication.class, args);
	}

}
