package com.rms.dtomodel;

import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.rms.model.Room;

public class RoomDTOTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testRoomDTO() {
        RoomDTO creation = new RoomDTO();
        creation.setId(1);
        creation.setRoomNumber("1406");
        creation.setMaxOccupancy(1);

        Room add = modelMapper.map(creation, Room.class);
        assertEquals(creation.getId(), add.getId());
        assertEquals(creation.getRoomNumber(), add.getRoomNumber());
        assertEquals(creation.getMaxOccupancy(), add.getMaxOccupancy());
    }
}