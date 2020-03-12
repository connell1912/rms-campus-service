package com.rms.service;

import com.rms.dao.ResourceMetadataDao;
import com.rms.model.ResourceMetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The ResourceMetadataService class communicates with the ResourceMetadataDao interface. It returns the appropriate objects
 * and offers more descriptive method names.
 */
@Service
public class ResourceMetadataService {

    @Autowired
    ResourceMetadataDao rmd;

    public void save(ResourceMetadata rm){
        rmd.save(rm);
    }

    public ResourceMetadata findById(int id){
        return rmd.findById(id);
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