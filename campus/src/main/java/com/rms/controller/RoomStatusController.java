package com.rms.controller;

import com.rms.model.RoomStatus;
import com.rms.service.RoomStatusService;

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
@RequestMapping(value = "/roomstatus")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomStatusController {

    @Autowired
    RoomStatusService rss;

    @GetMapping("/all")
    public Iterable<RoomStatus> getAllRoomStatuses() {
        return rss.findAll();
    }

    @GetMapping("/{id}")
    public RoomStatus findRoomStatusById(@PathVariable("id") int id) {
        return rss.findRoomStatusById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody RoomStatus rs) {
        rss.save(rs);
        return "Room Status has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody RoomStatus rs) {
        rss.update(rs);
        return "Room Status has been updated";
    }

    // update by ID in case we need it
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        rss.updateById(id);
        return "Room Status has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody RoomStatus rs) {
        rss.delete(rs);
        return "Room Status has been deleted";
    }

    // delete by ID in case we need it
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        rss.deleteById(id);
        return "Room Status has been deleted by ID";
    }
    
}