package com.rms.controller;

import com.rms.dao.AmenityDao;
import com.rms.model.Amenity;
import com.rms.service.AmenityService;

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
@RequestMapping(value = "/amenity")
@CrossOrigin(origins = "http://localhost:3000")
public class AmenityController {

    @Autowired
    AmenityService as;

    @GetMapping("/all")
    public Iterable<Amenity> getAllAmenityes() {
        return as.findAll();
    }

    @GetMapping("/{id}")
    public Amenity findAmenityById(@PathVariable("id") int id) {
        return as.findAmenityById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Amenity a) {
        as.save(a);
        return "Amenity has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Amenity a) {
        as.update(a);
        return "Amenity has been updated";
    }

    // update by ID in case we need it
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        as.updateById(id);
        return "Amenity has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Amenity a) {
        as.delete(a);
        return "Amenity has been deleted";
    }

    // delete by ID in case we need it
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        as.deleteById(id);
        return "Amenity has been deleted by ID";
    }
}