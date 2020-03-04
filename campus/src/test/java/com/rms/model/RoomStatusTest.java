package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class RoomStatusTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        RoomStatus rs = new RoomStatus(true, true, true);
        assertTrue(rs.equals(new RoomStatus(true, true, true)));
    }

    @Test
    public void testOtherConstructor() {
        RoomStatus rs = new RoomStatus(true, true, true, "", 1);
        assertTrue(rs.equals(new RoomStatus(true, true, true, "", 1)));
    }

}