package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.rms.dao.RoomStatusDao;
import com.rms.model.RoomStatus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RoomStatusServiceTest {

    @InjectMocks
    RoomStatusService rss;

    @Mock
    RoomStatusDao rsd;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        RoomStatus test = new RoomStatus(true, true, true);
        rss.save(test);
        verify(rsd, times(1)).save(test);
    }

    @Test
    public void testFindById() {
        when(rsd.findById(1)).thenReturn(new RoomStatus(true, true, true));
        RoomStatus test = rss.findRoomStatusById(1);
        assertNotNull(test);
    }

    @Test
    public void testReadAll() {
        List<RoomStatus> list = new ArrayList<>();
        RoomStatus rs = new RoomStatus(true, true, true);
        list.add(rs);
        when(rsd.findAll()).thenReturn(list);
        List<RoomStatus> statusList = rss.findAll();
        assertEquals(1, statusList.size());
        verify(rsd, times(1)).findAll();
    }

    @Test
    public void testUpdate() {
        RoomStatus test = new RoomStatus(true, true, true);
        rss.save(test);
        RoomStatus test2 = rss.findRoomStatusById(1);
        test2 = new RoomStatus(true, false, true);
        rss.update(test2);
        assertNotSame(test, test2);
    }

    @Test
    public void testDelete() {
        RoomStatus delete = new RoomStatus(true, true, true);
        rss.save(delete);
        RoomStatus add2 = rss.findRoomStatusById(1);
        rss.delete(add2);
        RoomStatus add3 = rss.findRoomStatusById(1);
        assertFalse(add3 != null);
    }

}