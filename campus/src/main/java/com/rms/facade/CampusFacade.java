package com.rms.facade;

import com.rms.dtomodel.CampusDTO;
import com.rms.model.Campus;
import com.rms.service.CampusService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CampusFacade {

    @Autowired
    CampusService cs;

    @Autowired
    ModelMapper m;

    public CampusDTO convertToCampusDTO(Campus camp){
        return m.map(camp, CampusDTO.class);
    }

    public Campus convertToEntity(CampusDTO camp) {
        return m.map(camp, Campus.class);
    }

    public CampusDTO getCampusById(int id){
        return convertToCampusDTO(cs.findCampusById(id));
    }
}