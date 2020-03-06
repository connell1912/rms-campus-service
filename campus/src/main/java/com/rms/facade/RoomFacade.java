package com.rms.facade;

import com.rms.dtomodel.RoomDTO;
import com.rms.model.Room;
import com.rms.service.RoomService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomFacade {

    @Autowired
    RoomService cs;

    @Autowired
    ModelMapper m;

    public RoomDTO convertToRoomDTO(Room camp){
        return m.map(camp, RoomDTO.class);
    }

    public Room convertToEntity(RoomDTO camp) {
        return m.map(camp, Room.class);
    }

    public RoomDTO getRoomById(int id){
        return convertToRoomDTO(cs.findRoomById(id));
    }
}