package com.rms.dtomodel;

import static org.junit.Assert.assertEquals;

import com.rms.model.Building;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class BuildingDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testBuildingDTO() {
        BuildingDTO creation = new BuildingDTO();
        creation.setId(1000);
        creation.setName("test-name");

        Building add = modelMapper.map(creation, Building.class);
        assertEquals(creation.getId(), add.getId());
        assertEquals(creation.getName(), add.getName());
    } 
    

}