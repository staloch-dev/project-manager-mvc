package com.mvc.project.product_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
		System.out.println("System started successfully!");
		System.out.println("Access: http://localhost:8080");
	}
}

