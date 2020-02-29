package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rms.model.Amenity;
import com.rms.model.AmenityStatus;
import com.rms.model.AmenityType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmenityServiceTest{

    @Autowired
    AmenityService as;

    @Test
    public void testReadAllAmenities(){
        Iterable<Amenity> am = as.findAll();
        assertNotNull(am);
    }

    @Test
    public void testFindAmenityById(){
        Amenity am = as.findAmenityById(1);
        assertTrue(am != null);
    }

    @Test
    public void testSaveNewAmenity(){
        AmenityType type = AmenityType.COFFEE;
        AmenityStatus status = AmenityStatus.LOW;
        as.save(new Amenity(type, status));
        Amenity am = as.findAmenityById(1);
        assertNotNull(am);
    }

    @Test
    public void testUpdateAmenity(){
        Amenity am = as.findAmenityById(1);
        AmenityStatus status = AmenityStatus.OUT;
        am.setStatus(status);
        as.update(am);
        assertTrue(am.getStatus().equals(status));
    }

    @Test
    public void testDeleteAmenity(){
        as.deleteById(1);
        assertTrue(as.findAmenityById(1) == null);
    }
}