package com.rms.controller;

import com.rms.model.Address;
import com.rms.service.AddressService;

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
 * The AddressController class communicates with our front end. This class includes
 * the annotations: 
 * @RequestMapping maps the request for our class
 * @CrossOrigins the communcation with the port tied to the front end
 * @OtherAnnotations
 * Other annotations include mappings tied to a specific HTTP method and are used to further describe 
 * the URL pattern for each method. These methods handle HTTP request differently and will display 
 * appropriate information once called. This is achieved by communicating with the AddressService class
 * which is wired using the Autowired annotation.
 */
@RestController
@RequestMapping(value = "/address")
@CrossOrigin(origins = { "http://localhost:3000" })
public class AddressController {

    @Autowired
    AddressService as;

    @GetMapping("/all")
    public Iterable<Address> getAllAddresses() {
        return as.findAll();
    }

    @GetMapping("/{id}")
    public Address findAddressById(@PathVariable("id") int id) {
        return as.findAddressById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody Address add) {
        as.save(add);
        return "Address has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Address add) {
        as.update(add);
        return "Address has been updated";
    }

    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        as.updateById(id);
        return "Address has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Address add) {
        as.delete(add);
        return "Address has been deleted";
    }

    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        as.deleteById(id);
        return "Address has been deleted by ID";
    }

}