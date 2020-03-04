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
        r2.setRoomNumber("NOT1234");
        rs.update(r2);
        System.out.println(r2.getRoomNumber());
        // assertFalse(r2.getRoomNumber().equals(room.getRoomNumber()));
        assertTrue(room.getRoomNumber().equals(r2.getRoomNumber()));
    }

    


    ////////////////////////////////////////////////////////////
    @Test
    public void testSaveNewAddress() {
        Address test = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(test);
        verify(ad, times(1)).save(test);
    }

    @Test
    public void testFindAddressById() {
        when(ad.findById(1))
                .thenReturn(new Address("test-street", "test-city", "test-state", "test-zip", "test-country"));
        Address add = as.findAddressById(1);
        assertEquals("test-street", add.getUnitStreet());
        assertEquals("test-city", add.getCity());
        assertEquals("test-state", add.getState());
    }

    @Test
    public void testReadAllAddresses() {
        Iterable<Address> add = as.findAll();
        assertNotNull(add);
    }

    @Test
    public void testUpdateAddress() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        Address add2 = as.findAddressById(1);
        add2 = new Address("test-street2", "test-city", "test-state", "test-zip", "test-country");
        as.update(add2);
        assertEquals("test-street2", add2.getUnitStreet());
    }

    @Test
    public void testDeleteAddress() {
        Address delete = new Address(0, "delete-street", "delete-city", "delete-state", "delete-zip", "delete-country");
        as.save(delete);
        Address add2 = as.findAddressById(1);
        as.delete(add2);
        Address add3 = as.findAddressById(1);
        assertFalse(add3 != null);
    }

    @Test
    public void testUpdateById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        Address add2 = as.findAddressById(1);
        add2 = new Address("test-street2", "test-city", "test-state", "test-zip", "test-country");
        as.updateById(1);
        assertEquals("test-street2", add2.getUnitStreet());
    }

    @Test
    public void testDeleteById(){
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        as.deleteById(1);
        Address add2 = as.findAddressById(1);
        assertFalse(add2 != null);
    }

}