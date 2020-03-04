package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ResourceMetadataService {

    @Autowired
    ResourceMetadataDao rmd;

    public void insert(ResourceMetadata rm){
        rmd.save(rm);
    }

    public void update(ResourceMetadata rm){
        rmd.save(rm);
    }

    // update by ID in case we need it
    public void updateByID(int id){
        ResourceMetadata rm = rmd.findById(id).get();
        rmd.save(rm);
    }

}