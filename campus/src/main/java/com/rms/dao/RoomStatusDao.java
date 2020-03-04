package com.rms.dao;

import com.rms.model.RoomStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomStatusDao extends CrudRepository<RoomStatus, Integer>{

    RoomStatus findById(int id);
}