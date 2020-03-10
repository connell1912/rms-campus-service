package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class AmenityTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        Amenity am = new Amenity(1, AmenityType.COFFEE, AmenityStatus.OK);
        assertTrue(am.equals(new Amenity(1, AmenityType.COFFEE, AmenityStatus.OK)));
    }

}