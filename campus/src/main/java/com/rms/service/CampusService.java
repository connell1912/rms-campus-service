package com.rms.service;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The CampusService class communicates with the CampusDao interface. It returns the appropriate objects
 * and offers more descriptive method names.
 */
@Service
public class CampusService {

    @Autowired
    CampusDao cd;

    public Iterable<Campus> findAll(){
        return cd.findAll();
    }

    public Campus findCampusById(int id){
        return cd.findById(id);
    }

    public void save(Campus camp){
        cd.save(camp);
    }

    public void update(Campus camp){
        cd.save(camp);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Campus camp = cd.findById(id);
        cd.save(camp);
    }

    public void delete(Campus camp){
        cd.delete(camp);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Campus camp = cd.findById(id);
        cd.delete(camp);
    }
}

