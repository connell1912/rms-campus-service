package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ModelTest {

    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        Address add = new Address(1, "test-street", "test-city", "test-state", "test-zip", "test-country");
        assertTrue(add.equals(new Address(1, "test-street", "test-city", "test-state", "test-zip", "test-country")));
    }

    @Test
    public void testRoomConstructor() {
        Room r = new Room("roomNumber1", 12, true, "Open");
        assertTrue(r.equals(new Room("roomNumber1", 12, true, "Open")));

    }

}