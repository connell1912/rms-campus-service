package com.rms;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// @EnableEurekaClient
@SpringBootApplication
public class CampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AddressDao rd) {
		return args -> {rd.save(new Address("12702 Bruce B Downs Blvd", "Tampa", "Florida", "33612", "US"));};
	}

	
}
