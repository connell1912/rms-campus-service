package com.rms.service;

import com.rms.dao.RoomDao;
import com.rms.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    
    @Autowired
    RoomDao rd;

    public Iterable<Room> findAll(){
        return rd.findAll();
    }

    public Room findRoomById(int id){
        return rd.findById(id).get();
    }

    public void save(Room room){
        rd.save(room);
    }

    public void update(Room room){
        rd.save(room);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Room room = rd.findById(id).get();
        rd.save(room);
    }

    public void delete(Room room){
        rd.delete(room);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Room room = rd.findById(id).get();
        rd.delete(room);
    }
}