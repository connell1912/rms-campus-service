package com.rms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.rms.model.Room;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class RoomControllerTests extends AbstractTest {
    private String roomNumber;
    private int maxOccupancy;
    private boolean isActive;
    private String currentStatus;
    private int batchId;
    private int[] workOrders;
    private Room room;
    
    @Override
    @Before
    public void setUp() {
        super.setUp();
        roomNumber = "1234";
        maxOccupancy = 33;
        isActive = true;
        currentStatus = "Open";
        batchId = 1;
        workOrders = new int[] {1, 2};
        room = new Room(roomNumber, maxOccupancy, isActive, currentStatus, batchId, workOrders);
    }

    @Test
    public void getRoomList() throws Exception {
        String uri = "/room/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Room[] rl = super.mapFromJson(content, Room[].class);
        assertTrue(rl.length > 0);
    }

    @Test
    public void createRoom() throws Exception {
        String uri = "/room/new";

        String inputJson = super.mapToJson(room);
        MvcResult mvcResult = mvc.perform(
            MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
            .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Room has been added");
    }

    @Test
    public void deleteRoom() throws Exception {
        String uri = "/room/deleted";

        String inputJson = super.mapToJson(room);
        MvcResult mvcResult = mvc.perform(
            MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
            .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Room has been deleted");
    }

    

}