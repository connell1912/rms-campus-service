package com.rms;

import com.rms.dao.RoomDao;
import com.rms.model.Room;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RoomDao rd) {
		return args -> {
			 rd.save(new Room(0, "Room 36", 30, true, "Status is Good", 3, null));
		};
	}

}
