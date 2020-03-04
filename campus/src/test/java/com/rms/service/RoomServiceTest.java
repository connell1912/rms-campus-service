package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.rms.dao.RoomDao;
import com.rms.dao.RoomDao2;
import com.rms.model.Room;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RoomServiceTest {

    private String roomNumber;
    private int maxOccupancy;
    private boolean isActive;
    private String currentStatus;
    private int batchId;
    private int[] workOrders;
    private Room room;

    @InjectMocks
    RoomService rs;

    @Mock
    RoomDao rd;

    @Before 
    public void init() {
        MockitoAnnotations.initMocks(this); 
        roomNumber = "1234";
        maxOccupancy = 33;
        isActive = true;
        currentStatus = "Open";
        batchId = 1;
        workOrders = new int[] {1, 2};
        room = new Room(roomNumber, maxOccupancy, isActive, currentStatus, batchId, workOrders);
    }

    @Test
    public void testSaveNewRoom() {
        rs.save(room);
        verify(rd, times(1)).save(room);
    }

    @Test
    public void testFindRoomById() {
        when(rd.findById(1)).thenReturn(Optional.of(room));
        Room r = rs.findRoomById(1);
        System.out.println(r);
        assertEquals("1234", r.getRoomNumber());
        assertEquals(33, r.getMaxOccupancy());
        assertEquals(true, r.getIsActive());
        assertEquals("Open", r.getCurrentStatus());
    }

    @Test 
    public void testReadAllRooms() {
        Iterable<Room> r = rs.findAll();
        assertNotNull(r);
    }

    @Test
    public void testUpdateRoom() {
        rs.save(room);
        System.out.println(room);
        when(rd.findById(1)).thenReturn(Optional.of(room));
        Room r2 = rs.findRoomById(1);
        r2.setRoomNumber("1234a");
        rs.update(r2);
        System.out.println(r2);
        assertTrue(room.getRoomNumber().equals(r2.getRoomNumber()));
    }

    

}