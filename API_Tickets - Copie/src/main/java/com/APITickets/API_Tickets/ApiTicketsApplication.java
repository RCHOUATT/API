package com.APITickets.API_Tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ApiTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTicketsApplication.class, args);
	}

}
