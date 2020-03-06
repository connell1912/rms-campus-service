package com.rms.controller;

import com.rms.facade.RoomFacade;
import com.rms.model.Room;
import com.rms.service.RoomService;

import com.rms.dtomodel.RoomDTO;

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

    @Autowired
    RoomFacade rf;

    // may need to use DTOs for this
    @GetMapping("/all")
    public Iterable<Room> getAllRooms() {
        return rs.findAll();
    }

    @GetMapping("/{id}")
    public RoomDTO findRoomById(@PathVariable("id") int id) {
        return rf.getRoomById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody RoomDTO rd) {
        Room room = rf.convertToEntity(rd);
        rs.save(room);
        return "Room has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody RoomDTO rd) {
        Room room = rf.convertToEntity(rd);
        rs.update(room);
        return "Room has been updated";
    }

    // update by ID in case we need it
    // may need to use DTOs for this 
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        rs.updateById(id);
        return "Room has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody RoomDTO rd) {
        Room room = rf.convertToEntity(rd);
        rs.delete(room);
        return "Room has been deleted";
    }

    // delete by ID in case we need it
    // may need to use DTOs for this
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        rs.deleteById(id);
        return "Room has been deleted by ID";
    }

}