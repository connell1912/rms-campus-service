package com.rms.service;

import com.rms.dao.RoomDao;
import com.rms.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The RoomService class communicates with the RoomDao interface. It returns the appropriate objects
 * and offers more descriptive method names.
 */
@Service
public class RoomService {

    @Autowired
    RoomDao rd;

    public void save(Room room) {
        rd.save(room);
    }

    public Room findRoomById(int id) {
        return rd.findById(id);
    }

    public List<Room> findAll() {
        return (List<Room>) rd.findAll();
    }

    public void update(Room room) {
        rd.save(room);
    }

    public void delete(Room room) {
        rd.delete(room);
    }

    // update by ID in case we need it
    public void updateById(int id) {
        Room room = rd.findById(id);
        rd.save(room);
    }

    // delete by ID in case we need it
    public void deleteById(int id) {
        Room room = rd.findById(id);
        rd.delete(room);
    }
}