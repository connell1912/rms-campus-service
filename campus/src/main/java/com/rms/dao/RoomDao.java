package com.rms.dao;

import com.rms.model.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomDao extends CrudRepository<Room, Integer>{

    Room findById(int id);
    
}