package com.rms.controller;

import com.rms.model.Building;
import com.rms.service.BuildingService;

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
@RequestMapping(value = "/building")
@CrossOrigin(origins = "*")
public class BuildingController {

    @Autowired
    BuildingService bs;

    @GetMapping("/all")
    public Iterable<Building> getAllBuildings() {
        return bs.findAll();
    }

    @GetMapping("/{id}")
    public Building findBuildingById(@PathVariable("id") int id) {
        return bs.findBuildingById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Building build) {
        bs.save(build);
        return "Building has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Building build) {
        bs.update(build);
        return "Building has been updated";
    }

    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        bs.updateById(id);
        return "Building has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Building build) {
        bs.delete(build);
        return "Building has been deleted";
    }

    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        bs.deleteById(id);
        return "Building has been deleted by ID";
    }
}