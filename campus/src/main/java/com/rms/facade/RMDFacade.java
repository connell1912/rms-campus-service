package com.rms.facade;

import com.rms.dtomodel.RMDDTO;
import com.rms.model.ResourceMetadata;
import com.rms.service.ResourceMetadataService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RMDFacade {

    @Autowired
    ResourceMetadataService rms;

    @Autowired
    ModelMapper m;

    public RMDDTO convertToRMDDTO(ResourceMetadata rm){
        return m.map(rm, RMDDTO.class);
    }

    public ResourceMetadata convertToEntity(RMDDTO rmd) {
        return m.map(rmd, ResourceMetadata.class);
    }

    public RMDDTO getRMDById(int id){
        return convertToRMDDTO(rms.findById(id));
    }
}