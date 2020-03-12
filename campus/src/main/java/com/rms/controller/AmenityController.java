package com.rms.controller;

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

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The AmenityController class communicates with our front end. This class includes
 * the annotations: 
 * @RequestMapping maps the request for our class
 * @CrossOrigins the communcation with the port tied to the front end
 * @OtherAnnotations
 * Other annotations include mappings tied to a specific HTTP method and are used to further describe 
 * the URL pattern for each method. These methods handle HTTP request differently and will display 
 * appropriate information once called. This is achieved by communicating with the AmenityService class
 * which is wired using the Autowired annotation.
 */
@RestController
@RequestMapping(value = "/amenity")
@CrossOrigin(origins = "http://localhost:3000")
public class AmenityController {

    @Autowired
    AmenityService as;

    @GetMapping("/all")
    public Iterable<Amenity> getAllAmenities() {
        return as.findAll();
    }

    @GetMapping("/{id}")
    public Amenity findAmenityById(@PathVariable("id") int id) {
        return as.findAmenityById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Amenity am) {
        as.save(am);
        return "Amenity has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Amenity am) {
        as.update(am);
        return "Amenity has been updated";
    }

    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        as.updateById(id);
        return "Amenity has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Amenity am) {
        as.delete(am);
        return "Amenity has been deleted";
    }

    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        as.deleteById(id);
        return "Amenity has been deleted by ID";
    }
}