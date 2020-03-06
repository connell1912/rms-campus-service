package com.rms.controller;

import com.rms.facade.AddressFacade;
import com.rms.model.Address;
import com.rms.dtomodel.AddressDTO;
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

@RestController
@RequestMapping(value = "/address")
@CrossOrigin(origins = { "http://localhost:3000" })
public class AddressController {

    @Autowired
    AddressService as;

    @Autowired
    AddressFacade af;

    // may need to use DTOs for this
    @GetMapping("/all")
    public Iterable<Address> getAllAddresses() {
        return as.findAll();
    }

    @GetMapping("/{id}")
    public AddressDTO findAddressById(@PathVariable("id") int id) {
        return af.getAddressById(id);
    }

    @PostMapping("/new")
    public String insert(@RequestBody AddressDTO ad) {
        Address a = af.convertToEntity(ad);
        as.save(a);
        return "Address has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody AddressDTO ad) {
        Address a = af.convertToEntity(ad);
        as.update(a);
        return "Address has been updated";
    }

    // update by ID in case we need it
    // may need to use DTOs for this
    @PutMapping("/updatedbyid")
    public String updateById(@RequestBody int id){
        as.updateById(id);
        return "Address has been updated by its ID";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody AddressDTO ad) {
        Address a = af.convertToEntity(ad);
        as.delete(a);
        return "Address has been deleted";
    }

    // delete by ID in case we need it
    // may need to use DTOs for this 
    @DeleteMapping("/deletedbyid")
    public String deleteById(@RequestBody int id){
        as.deleteById(id);
        return "Address has been deleted by ID";
    }

}