package com.builder.building_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildingManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuildingManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome! The server is running on port 8081.");
	}

}
