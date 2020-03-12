package com.rms.controller;

import com.rms.model.Campus;
import com.rms.service.CampusService;

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

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The CampusController class communicates with our front end. This class includes
 * the annotations: 
 * @RequestMapping maps the request for our class
 * @CrossOrigins the communcation with the port tied to the front end
 * @OtherAnnotations
 * Other annotations include mappings tied to a specific HTTP method and are used to further describe 
 * the URL pattern for each method. These methods handle HTTP request differently and will display 
 * appropriate information once called. This is achieved by communicating with the CampusService class
 * which is wired using the Autowired annotation.
 */
@RestController
@RequestMapping(value = "/campus")
@CrossOrigin(origins = "http://localhost:3000")
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

    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        cs.deleteById(id);
        return "Campus has been deleted by ID";
    }
}