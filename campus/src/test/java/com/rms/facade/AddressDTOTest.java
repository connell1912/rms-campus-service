package com.rms.facade;

import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.rms.model.Address;
import com.rms.model.AddressDTO;

public class AddressDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testAddressDTO() {
        AddressDTO creation = new AddressDTO();
        creation.setUnitStreet("test-street");
        creation.setCity("test-city");
        creation.setState("test-state");
        creation.setZip("test-zip");
        creation.setCountry("test-country");

        Address add = modelMapper.map(creation, Address.class);
        assertEquals(creation.getUnitStreet(), add.getUnitStreet());
        assertEquals(creation.getCity(), add.getCity());
        assertEquals(creation.getState(), add.getState());
        assertEquals(creation.getZip(), add.getZip());
        assertEquals(creation.getCountry(), add.getCountry());
    }

}