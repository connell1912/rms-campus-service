package com.rms.facade;

import com.rms.model.Address;
import com.rms.model.AddressDTO;
import com.rms.service.AddressService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressFacade {

    @Autowired
    AddressService as;

    @Autowired
    ModelMapper m;

    private AddressDTO convertToAddressDTO(Address add){
        return m.map(add, AddressDTO.class);
    }

    private Address convertToEntity(AddressDTO ad) {
        return m.map(ad, Address.class);
    }

    public AddressDTO getAddressById(int id){
        return convertToAddressDTO(as.findAddressById(id));
    }

    // public Address updateAdress(AddressDTO ad) {
    //     return convertToEntity(dd.save(ad));
    // }

    // public Address updateAddressById(int id) {
    //     return convertToEntity(as.updateById(id));
    // }

    // public Address insertAddress(AddressDTO ad) {
    //     return convertToEntity(dd.save(ad));
    // }

    // public Address deleteAddress(AddressDTO ad) {
    //     return convertToEntity(dd.delete(ad));
    // }

    // public AddressDTO deleteAddressById(int id) {
    //     return convertToAddressDTO(as.deleteById(id));
    // }
}