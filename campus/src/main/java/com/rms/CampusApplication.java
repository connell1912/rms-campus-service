package com.rms;

// import com.rms.dao.AddressDao;
// import com.rms.dao.AmenityDao;
import com.rms.dao.BuildingDao;
import com.rms.model.Address;
import com.rms.model.Amenity;
// import com.rms.model.Address;
// import com.rms.model.Amenity;
// import com.rms.model.AmenityStatus;
// import com.rms.model.AmenityType;
import com.rms.model.Building;
import com.rms.model.ResourceMetadata;
import com.rms.model.Room;

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

	// @Bean
	// CommandLineRunner runner(BuildingDao rd) {
	// 	return args -> {
	// 		// rd.save(new Address("12702 Bruce B Downs Blvd", "Tampa", "Florida", "33612",
	// 		// "US"));
	// 		// rd.save(new Amenity(AmenityType.COFFEE, AmenityStatus.OK));
	// 		Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
	// 		Amenity[] am = new Amenity[2];
	// 		Room[] room = new Room[3];
	// 		ResourceMetadata rmd = new ResourceMetadata();
	// 		rd.save(new Building("Business of College", "Muma", add, 1, am, room, rmd));
	// 	};
	// }

}
