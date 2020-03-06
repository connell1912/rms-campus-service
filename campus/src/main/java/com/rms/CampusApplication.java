package com.rms;

import com.rms.dao.AddressDao;
import com.rms.dtomodel.AddressDTO;
import com.rms.dtomodel.BuildingDTO;
import com.rms.facade.AddressFacade;
import com.rms.facade.AmenityFacade;
import com.rms.facade.BuildingFacade;
import com.rms.facade.CampusFacade;
import com.rms.facade.RMDFacade;
import com.rms.facade.RoomFacade;
import com.rms.facade.RoomStatusFacade;
import com.rms.model.Address;
import com.rms.model.Building;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
    public ModelMapper modelMapper(){
		ModelMapper mm = new ModelMapper();
		PropertyMap<BuildingDTO, Building> propertyMap = new PropertyMap<BuildingDTO, Building> (){
			protected void configure() {
				map(source.getResourceMetadata()).setResourceMetadata(null);
			}
		};
	
		mm.addMappings(propertyMap);
		return mm;
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
	public RMDFacade rmdFacade() {
		return new RMDFacade();
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
