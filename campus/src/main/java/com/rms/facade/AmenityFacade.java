package com.rms.facade;

import com.rms.model.Amenity;
import com.rms.dtomodel.AmenityDTO;
import com.rms.service.AmenityService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AmenityFacade {

    @Autowired
    AmenityService as;

    @Autowired
    ModelMapper m;

    public AmenityDTO convertToAmenityDTO(Amenity add){
        return m.map(add, AmenityDTO.class);
    }

    public Amenity convertToEntity(AmenityDTO ad) {
        return m.map(ad, Amenity.class);
    }

    public AmenityDTO getAmenityById(int id){
        return convertToAmenityDTO(as.findAmenityById(id));
    }

}