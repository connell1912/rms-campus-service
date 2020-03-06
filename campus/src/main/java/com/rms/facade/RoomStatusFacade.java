package com.rms.facade;

import com.rms.dtomodel.RoomStatusDTO;
import com.rms.model.RoomStatus;
import com.rms.service.RoomStatusService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomStatusFacade {

    @Autowired
    RoomStatusService rss;

    @Autowired
    ModelMapper m;

    public RoomStatusDTO convertToRoomStatusDTO(RoomStatus rs){
        return m.map(rs, RoomStatusDTO.class);
    }

    public RoomStatus convertToEntity(RoomStatusDTO rsd) {
        return m.map(rsd, RoomStatus.class);
    }

    public RoomStatusDTO getRoomStatusById(int id){
        return convertToRoomStatusDTO(rss.findRoomStatusById(id));
    }
}