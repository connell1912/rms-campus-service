package com.rms.dtomodel;

import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.rms.model.RoomStatus;

public class RoomStatusDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testRoomStatusDTO() {
        RoomStatusDTO creation = new RoomStatusDTO();
        creation.setId(100);
        creation.setOtherNotes("otherNotes");

        RoomStatus add = modelMapper.map(creation, RoomStatus.class);
        assertEquals(creation.getId(), add.getId());
        assertEquals(creation.getOtherNotes(), add.getOtherNotes());
    }
}