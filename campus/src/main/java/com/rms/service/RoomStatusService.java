package com.rms.service;

import java.util.List;

import com.rms.dao.RoomStatusDao;
import com.rms.model.RoomStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * @Author 1912dec16 Java Fullstack batch
 * 
 * 
 * The RoomStatusService class provides the connections between the
 *  RoomStatusDao and the RoomStatusController.  The RoomStatusDao is
 *  wired by using the Autowired annotation.  It provides the connections
 *  by calling the CRUD methods within the DAO layer and transferring them
 *  to the Controller layer, and vice versa.  This is to provide the
 *  necessary layer separation according to JEE2 specifications.
 */
public class RoomStatusService {
    
    @Autowired
    RoomStatusDao rsd;

    public List<RoomStatus> findAll(){
        return (List<RoomStatus>) rsd.findAll();
    }

    public RoomStatus findRoomStatusById(int id){
        return rsd.findById(id);
    }

    public void save(RoomStatus rs){
        rsd.save(rs);
    }

    public void update(RoomStatus rs){
        rsd.save(rs);
    }

    // update by ID in case we need it
    public void updateById(int id){
        RoomStatus rs = rsd.findById(id);
        rsd.save(rs);
    }

    public void delete(RoomStatus rs){
        rsd.delete(rs);
    }

    // delete by ID in case we need it
    public void deleteById(int id){
        RoomStatus rs = rsd.findById(id);
        rsd.delete(rs);
    }
}