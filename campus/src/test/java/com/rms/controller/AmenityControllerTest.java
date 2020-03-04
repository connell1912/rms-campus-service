package com.rms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.rms.model.Amenity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AmenityControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllAmenities() throws Exception {
        String uri = "/amenity/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Amenity[] add = super.mapFromJson(content, Amenity[].class);
        assertTrue(add.length > 0);
    }

}