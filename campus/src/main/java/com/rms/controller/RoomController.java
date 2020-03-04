package com.rms.controller;

import com.rms.model.Room;
import com.rms.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/room")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {
    
    @Autowired
    RoomService rs;

    @GetMapping("/all")
    public Iterable<Room> getAllRoomes() {
        return rs.findAll();
    }

    @GetMapping("/{id}")
    public Room findRoomById(@PathVariable("id") int id) {
        return rs.findRoomById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Room room) {
        rs.save(room);
        return "Room has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Room room) {
        rs.update(room);
        return "Room has been updated";
    }

    // update by ID in case we need it
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        rs.updateById(id);
        return "Room has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Room room) {
        rs.delete(room);
        return "Room has been deleted";
    }

    // delete by ID in case we need it
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        rs.deleteById(id);
        return "Room has been deleted by ID";
    }

}