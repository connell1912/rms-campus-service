package com.rms.service;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    @Autowired
    CampusDao cd;

    public Iterable<Campus> findAll(){
        return cd.findAll();
    }

    public Campus findCampusById(int id){
        return cd.findById(id).get();
    }

    public void save(Campus camp){
        cd.save(camp);
    }

    public void update(Campus camp){
        cd.save(camp);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Campus camp = cd.findById(id).get();
        cd.save(camp);
    }

    public void delete(Campus camp){
        cd.delete(camp);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Campus camp = cd.findById(id).get();
        cd.delete(camp);
    }
}

