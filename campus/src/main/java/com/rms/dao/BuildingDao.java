package com.rms.dao;

import javax.transaction.Transactional;

import com.rms.model.Building;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BuildingDao extends CrudRepository<Building, Integer>{

    
}