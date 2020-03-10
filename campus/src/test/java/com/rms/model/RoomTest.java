package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class RoomTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        RoomStatus status = new RoomStatus();
        int[] wo = new int[] { 1, 2, 3, 4 };
        ResourceMetadata rmd = new ResourceMetadata();
        Room r = new Room("1406", 33, false, status, 1912, wo, rmd);
        assertTrue(r.equals(new Room("1406", 33, false, status, 1912, wo, rmd)));
    }

}