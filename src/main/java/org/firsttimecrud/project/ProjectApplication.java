package org.firsttimecrud.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//The question is why we use @SpringBootApplication annotation?
//Ans: The @SpringBootApplication annotation is a convenience annotation that combines three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.
// It is used to mark the main class of a Spring Boot application and enables auto-configuration and component scanning.
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		//The question is why we use SpringApplication.run() method?
		//Ans: The SpringApplication.run() method is used to launch a Spring Boot application.
		// It sets up the default configuration, starts the Spring application context, performs class path scanning, and starts the embedded web server (if applicable).
		SpringApplication.run(ProjectApplication.class, args);
		
	}

}
