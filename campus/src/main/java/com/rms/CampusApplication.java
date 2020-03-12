package com.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The CampusApplication class runs the Tomcat server.
 */
@EnableEurekaClient
@SpringBootApplication
public class CampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusApplication.class, args);
	}

}
