package com.rms.dtomodel;

import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.rms.model.Campus;

public class CampusDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testCampusDTO() {
        CampusDTO creation = new CampusDTO();
        creation.setName("test-name");
        creation.setAbbrName("test-abbrName");

        Campus add = modelMapper.map(creation, Campus.class);
        assertEquals(creation.getName(), add.getName());
        assertEquals(creation.getAbbrName(), add.getAbbrName());
    }
}