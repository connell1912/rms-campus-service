package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.rms.dao.RoomDao;
import com.rms.model.ResourceMetadata;
import com.rms.model.Room;
import com.rms.model.RoomStatus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RoomServiceTest {

    private RoomStatus status;
    private int[] wo;
    private ResourceMetadata rmd;
    private Room test;

    @InjectMocks
    RoomService rs;

    @Mock
    RoomDao rd;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        status = new RoomStatus();
        wo = new int[] { 1, 2, 3, 4 };
        rmd = new ResourceMetadata();
        test = new Room("1406", 33, false, status, 1912, wo, rmd);
    }

    @Test
    public void testSave() {
        rs.save(test);
        verify(rd, times(1)).save(test);
    }

    @Test
    public void testFindById() {
        when(rd.findById(1)).thenReturn(test);
        Room test1 = rs.findById(1);
        assertNotNull(test1);
    }

    @Test
    public void testReadAll() {
        List<Room> list = new ArrayList<>();
        list.add(test);
        when(rd.findAll()).thenReturn(list);
        List<Room> statusList = rs.findAll();
        assertEquals(1, statusList.size());
        verify(rd, times(1)).findAll();
    }

    @Test
    public void testUpdate() {
        rs.save(test);
        Room test2 = rs.findById(1);
        test2 = new Room("1406", 32, false, status, 1912, wo, rmd);
        rs.update(test2);
        assertNotSame(test, test2);
    }

    @Test
    public void testDelete() {
        rs.save(test);
        Room add2 = rs.findById(1);
        rs.delete(add2);
        Room add3 = rs.findById(1);
        assertFalse(add3 != null);
    }

    @Test
    public void updateById() {
        System.out.println(test);
        when(rd.findById(1)).thenReturn(test);
        test.setActive(true);
        System.out.println(test);
        rs.update(test);
        assertSame(test, test);
    }

    @Test
    public void deleteById() {
        when(rd.findById(1)).thenReturn(test);
        rs.delete(test);
        Room test1 = rs.findById(0);
        System.out.println(test1);
        assertNull(test1);
    }

}