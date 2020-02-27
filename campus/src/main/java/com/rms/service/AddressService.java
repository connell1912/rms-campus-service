package com.rms.service;

import java.util.List;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    AddressDao ad;

    public void save(Address add){
        ad.save(add);
    }

    public void update(Address add){
        ad.save(add);
    }

    public void delete(Address add){
        ad.delete(add);
    }

    public List<Address> findAll() {
        return (List<Address>) ad.findAll();
    }
}