package com.rms;

import com.rms.facade.AddressFacade;
import com.rms.facade.AmenityFacade;
import com.rms.facade.BuildingFacade;
import com.rms.facade.CampusFacade;
import com.rms.facade.RoomFacade;
import com.rms.facade.RoomStatusFacade;

import org.modelmapper.ModelMapper;
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
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public AddressFacade addressFacade(){
        return new AddressFacade();
	}

	@Bean
	public AmenityFacade amenityFacade() {
		return new AmenityFacade();
	}

	@Bean
	public BuildingFacade buildingFacade() {
		return new BuildingFacade();
	}

	@Bean
	public CampusFacade campusFacade() {
		return new CampusFacade();
	}

	@Bean
	public RoomFacade roomFacade() {
		return new RoomFacade();
	}

	@Bean
	public RoomStatusFacade roomStatusFacade() {
		return new RoomStatusFacade();
	}

	// @Bean
	// CommandLineRunner runner(AddressDao rd) {
	// 	return args -> {
	// 		rd.save(new Address("12702 Bruce B Downs Blvd", "Tampa", "Florida", "33612",
	// 		"US"));
	// 		// rd.save(new Amenity(AmenityType.COFFEE, AmenityStatus.OK));
	// 		// Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
	// 		// Amenity[] am = new Amenity[2];
	// 		// Room[] room = new Room[3];
	// 		// ResourceMetadata rmd = new ResourceMetadata();
	// 		// rd.save(new Building("Business of College", "Muma", add, 1, am, room, rmd));
	// 	};
	// }

}
