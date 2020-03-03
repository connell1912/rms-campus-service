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

    // @Column
    // @OneToOne
    // private ResourceMetadata resourceMetadata;



    public Room(int id, String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus, int batchId, int[] workOrders) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.currentStatus = currentStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        // this.resourceMetadata = resourceMetadata;
    }

    public Room(String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus, int batchId, int[] workOrders) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.currentStatus = currentStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
    }
    
    public Room(String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus) {
    	this.roomNumber = roomNumber;
    	this.maxOccupancy = maxOccupancy;
    	this.isActive = isActive;
    	this.currentStatus = currentStatus;
    }

    public Room(String roomNumber, int maxOccupancy, boolean isActive, int batchId) {
    	this.roomNumber = roomNumber;
    	this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.batchId = batchId;
    }

    // public int getId() {
    //     return this.id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getRoomNumber() {
    //     return this.roomNumber;
    // }

    // public void setRoomNumber(String roomNumber) {
    //     this.roomNumber = roomNumber;
    // }

    // public int getMaxOccupancy() {
    //     return this.maxOccupancy;
    // }

    // public void setMaxOccupancy(int maxOccupancy) {
    //     this.maxOccupancy = maxOccupancy;
    // }

    // public boolean isIsActive() {
    //     return this.isActive;
    // }

    // public boolean getIsActive() {
    //     return this.isActive;
    // }

    // public void setIsActive(boolean isActive) {
    //     this.isActive = isActive;
    // }

    // public String getCurrentStatus() {
    //     return this.currentStatus;
    // }

    // public void setCurrentStatus(String currentStatus) {
    //     this.currentStatus = currentStatus;
    // }

    // public int getBatchId() {
    //     return this.batchId;
    // }

    // public void setBatchId(int batchId) {
    //     this.batchId = batchId;
    // }

    // public int[] getWorkOrders() {
    //     return this.workOrders;
    // }

    // public void setWorkOrders(int[] workOrders) {
    //     this.workOrders = workOrders;
    // }

    // public ResourceMetadata getResourceMetadata() {
    //     return this.resourceMetadata;
    // }
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