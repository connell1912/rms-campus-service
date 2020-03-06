package com.rms.controller;

import com.rms.dtomodel.BuildingDTO;
import com.rms.facade.BuildingFacade;
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

    @Autowired
    BuildingFacade bf;

    @GetMapping("/all")
    public Iterable<Building> getAllBuildings() {
        return bs.findAll();
    }

    @GetMapping("/{id}")
    public BuildingDTO findBuildingById(@PathVariable("id") int id) {
        return bf.getBuildingById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody BuildingDTO bd) {
        Building building = bf.convertToEntity(bd);
        bs.save(building);
        return "Building has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody BuildingDTO bd) {
        Building building = bf.convertToEntity(bd);
        bs.update(building);
        return "Building has been updated";
    }

    // update by ID in case we need it
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        bs.updateById(id);
        return "Building has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody BuildingDTO bd) {
        Building building = bf.convertToEntity(bd);
        bs.delete(building);
        return "Building has been deleted";
    }

    // delete by ID in case we need it
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        bs.deleteById(id);
        return "Building has been deleted by ID";
    }
}