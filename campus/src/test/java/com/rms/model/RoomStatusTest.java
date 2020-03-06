package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;

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
        Timestamp t = new Timestamp(1000);
        RoomStatus rs = new RoomStatus(true, true, true, t, 1, "");
        assertTrue(rs.equals(new RoomStatus(true, true, true, t, 1, "")));
    }

}