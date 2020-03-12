package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The Room class defines our Room model. It utilizes JPA to be able to be persisted into our H2 databases
 * and Lombok to have getters, setters, no/all args constructors through its annotations.
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roomNumber;

    private int maxOccupancy;

    private boolean isActive;
  
    @OneToOne
    private RoomStatus currentStatus;

    private int batchId;

    private int[] workOrders;

    @OneToOne
    private ResourceMetadata resourceMetadata;

    public Room(String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus, int batchId, int[] workOrders, ResourceMetadata resourceMetadata) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.currentStatus = currentStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

}