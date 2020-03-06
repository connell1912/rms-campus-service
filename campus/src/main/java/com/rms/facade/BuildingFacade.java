package com.rms.facade;

import com.rms.dtomodel.BuildingDTO;
import com.rms.model.Building;
import com.rms.service.BuildingService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BuildingFacade {

    @Autowired
    BuildingService bs;

    @Autowired
    ModelMapper m;

    public BuildingDTO convertToBuildingDTO(Building b){
        return m.map(b, BuildingDTO.class);
    }

    public Building convertToEntity(BuildingDTO b) {
        return m.map(b, Building.class);
    }

    public BuildingDTO getBuildingById(int id){
        return convertToBuildingDTO(bs.findBuildingById(id));
    }

}