package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.AmenityDao;
import com.rms.model.Amenity;
import com.rms.model.AmenityStatus;
import com.rms.model.AmenityType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AmenityServiceTest{

    @InjectMocks
    AmenityService as;

    @Mock
    AmenityDao ad;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNewAmenity() {
        Amenity am = new Amenity(AmenityType.COFFEE, AmenityStatus.LOW);
        as.save(am);
        verify(ad, times(1)).save(am);
    }

    @Test
    public void testFindAmenityById() {
        when(ad.findById(1)).thenReturn(new Amenity(AmenityType.COFFEE, AmenityStatus.LOW));
        Amenity am = as.findAmenityById(1);
        assertEquals(AmenityType.COFFEE, am.getType());
        assertEquals(AmenityStatus.LOW, am.getStatus());
    }

    @Test
    public void testReadAllAmenites() {
        Iterable<Amenity> am = as.findAll();
        assertNotNull(am);
    }

    @Test
    public void testUpdateAmenity() {
        Amenity am = new Amenity(AmenityType.COFFEE, AmenityStatus.LOW);
        as.save(am);
        Amenity am2 = as.findAmenityById(1);
        am2 = new Amenity(AmenityType.COFFEE, AmenityStatus.OK);
        as.update(am2);
        assertEquals(AmenityStatus.OK, am2.getStatus());
    }

    @Test
    public void testDeleteAmenity() {
        Amenity am = new Amenity(AmenityType.COFFEE, AmenityStatus.LOW);
        as.save(am);
        Amenity am2 = as.findAmenityById(1);
        as.delete(am2);
        Amenity am3 = as.findAmenityById(1);
        assertFalse(am3 != null);
    }

    @Test
    public void testUpdateById() {
        Amenity am = new Amenity(AmenityType.COFFEE, AmenityStatus.LOW);
        as.save(am);
        Amenity am2 = as.findAmenityById(1);
        am2 = new Amenity(AmenityType.COFFEE, AmenityStatus.OK);
        as.updateById(1);
        assertEquals(AmenityStatus.OK, am2.getStatus());
    }

    @Test
    public void testDeleteById(){
        Amenity am = new Amenity(AmenityType.COFFEE, AmenityStatus.LOW);
        as.save(am);
        as.deleteById(1);
        Amenity am2 = as.findAmenityById(1);
        assertFalse(am2 != null);
    }
}