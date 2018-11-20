package com.todoservice.gemfirerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
@SpringBootApplication
public class SpringBootGemfireRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGemfireRestfulApiApplication.class, args);
	}
}