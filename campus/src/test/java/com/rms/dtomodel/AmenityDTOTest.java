package com.rms.dtomodel;

import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.rms.model.Amenity;
import com.rms.model.AmenityStatus;
import com.rms.model.AmenityType;

public class AmenityDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testAmenityDTO() {
        AmenityDTO creation = new AmenityDTO();
        creation.setStatus(AmenityStatus.OK);
        creation.setType(AmenityType.CLEANING_WIPES);

        Amenity am = modelMapper.map(creation, Amenity.class);
        assertEquals(creation.getStatus(), am.getStatus());
        assertEquals(creation.getType(), am.getType());
    }

}