package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CampusTest {
    @Before
    public void setup() {

    }

    @Test
    public void testConstructor() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp);
        assertTrue(camp.equals(new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp)));
    }

}