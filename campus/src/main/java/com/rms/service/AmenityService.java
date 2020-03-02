package com.rms.service;

import com.rms.dao.AmenityDao;
import com.rms.model.Amenity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

    @Autowired
    AmenityDao ad;

    public Iterable<Amenity> findAll(){
        return ad.findAll();
    }

    public Amenity findAmenityById(int id){
        return ad.findById(id);
    }

    public void save(Amenity am){
        ad.save(am);
    }

    public void update(Amenity am){
        ad.save(am);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Amenity am = ad.findById(id);
        ad.save(am);
    }

    public void delete(Amenity am){
        ad.delete(am);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Amenity am = ad.findById(id);
        ad.delete(am);
    }
    
}