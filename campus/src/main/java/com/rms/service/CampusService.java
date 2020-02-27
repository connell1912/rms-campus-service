package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    @Autowired
   CampusDao cd;

    public void save(Campus camp) {
        cd.save(camp);
    }

    public void delete(Campus camp){
        cd.delete(camp);
    }

    public void update(Campus camp){
        cd.save(camp);
    }

    public Optional<Campus> findById(int id){
        return cd.findById(id);
    }

    public List<Campus> findAll() {
        return (List<Campus>) cd.findAll();
    }
}

