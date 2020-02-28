package com.rms.controller;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;
import com.rms.service.CampusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/campus")
public class CampusController {

    @Autowired
    CampusService cs;

    @GetMapping("/all")
    public Iterable<Campus> getAllCampuses() {
        return cs.findAll();
    }

    @GetMapping("/{id}")
    public Campus findCampusById(@PathVariable("id") int id) {
        return cs.findCampusById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Campus camp) {
        cs.save(camp);
        return "Campus has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Campus camp) {
        cs.update(camp);
        return "Campus has been updated";
    }

    // update by ID in case we need it
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        cs.updateById(id);
        return "Campus has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Campus camp) {
        cs.delete(camp);
        return "Campus has been deleted";
    }

    // delete by ID in case we need it
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        cs.deleteById(id);
        return "Campus has been deleted by ID";
    }
}