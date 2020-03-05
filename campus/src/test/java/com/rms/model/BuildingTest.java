package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class BuildingTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        assertTrue(build.equals(new Building("test-name", "test-abbr", add, 1, am, room, rmd)));
    }

}