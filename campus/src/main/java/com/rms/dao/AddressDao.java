package com.rms.dao;


import com.rms.model.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddressDao extends CrudRepository<Address, Integer>{

    Address findById(int id);

}