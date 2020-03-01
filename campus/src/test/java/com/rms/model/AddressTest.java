package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        Address add = new Address(1, "test-street", "test-city", "test-state", "test-zip", "test-country");
        assertTrue(add.equals(new Address(1, "test-street", "test-city", "test-state", "test-zip", "test-country")));
    }

}