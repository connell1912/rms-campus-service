package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.BuildingDao;
import com.rms.model.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    
    @Autowired
    BuildingDao bl;

    public void saveOrUpdate(Building bld) {
        bl.save(bld);
    }

    public void delete(Building bld) {
        bl.delete(bld);
    }

    public Iterable<Building> findAll(){
        return bl.findAll();
    }

    public Building findBuildingById(int id){
        return bl.findById(id);
    }

	public Building deleteById(int i) {
        return bl.deleteById(i);
	}


   
}