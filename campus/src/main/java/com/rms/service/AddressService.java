package com.rms.service;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    AddressDao ad;

    public Iterable<Address> findAll(){
        return ad.findAll();
    }

    public Address findAddressById(int id){
        return ad.findById(id);
    }

    public void save(Address add){
        ad.save(add);
    }

    public void update(Address add){
        ad.save(add);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Address add = ad.findById(id);
        ad.save(add);
    }

    public Address delete(Address add){
        ad.delete(add);
        return add;
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Address add = ad.findById(id);
        ad.delete(add);
    }
}