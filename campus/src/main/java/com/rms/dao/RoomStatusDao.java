package com.rms.dao;

import com.rms.model.RoomStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The RoomStatusDao interface communicates with our H2 database. It utilizes Spring Data and extends the 
 * CrudRepository which gives us access to built in CRUD methods and allows to create abstract methods using 
 * naming conventions that the CrudRepository recognizes and is able provide default implementation.
 */
@Repository
@Transactional
/**
 * @Author 1912dec16 Java Fullstack Batch
 * 
 * 
 * The RoomStatusDao interface communicates with our H2 database.
 *  It utilizes Spring Data and extends the Crud Repository to give us
 *  access to its built in CRUD methods and allows to create abstract methods
 *  using naming convention that the Crud Repository recognizes and is able
 *  to provide default implementation.
 */
public interface RoomStatusDao extends CrudRepository<RoomStatus, Integer>{

    RoomStatus findById(int id);

}