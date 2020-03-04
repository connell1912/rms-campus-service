package com.rms.service;

import com.rms.dao.ResourceMetadataDao;
import com.rms.model.ResourceMetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceMetadataService {

    @Autowired
    ResourceMetadataDao rmd;

    public ResourceMetadata findRmdById(int id) {
        return rmd.findById(id);
    }

    public void insert(ResourceMetadata rm){
        rmd.save(rm);
    }

    public void update(ResourceMetadata rm){
        rmd.save(rm);
    }

    // update by ID in case we need it
    public void updateByID(int id){
        ResourceMetadata rm = rmd.findById(id);
        rmd.save(rm);
    }

}