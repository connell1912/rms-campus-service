package com.rms.facade;

import com.rms.model.Address;
import com.rms.dtomodel.AddressDTO;
import com.rms.service.AddressService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressFacade {

    @Autowired
    AddressService as;

    @Autowired
    ModelMapper m;

    public AddressDTO convertToAddressDTO(Address add){
        return m.map(add, AddressDTO.class);
    }

    public Address convertToEntity(AddressDTO ad) {
        return m.map(ad, Address.class);
    }

    public AddressDTO getAddressById(int id){
        return convertToAddressDTO(as.findAddressById(id));
    }

}