package com.rms.service;

import com.rms.dao.BuildingDao;
import com.rms.model.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    
    @Autowired
    BuildingDao bd;

    public Iterable<Building> findAll(){
        return bd.findAll();
    }

    public Building findBuildingById(int id){
        return bd.findById(id).get();
    }

    public void save(Building build){
        bd.save(build);
    }

    public void update(Building build){
        bd.save(build);
    }

    // update by ID in case we need it
    public void updateById(int id){
        Building build = bd.findById(id).get();
        bd.save(build);
    }

    public void delete(Building build){
        bd.delete(build);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        Building build = bd.findById(id).get();
        bd.delete(build);
    }
}