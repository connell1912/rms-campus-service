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
 * The Building class defines our Building model. It utilizes JPA to be able to be persisted into our H2 databases
 * and Lombok to have getters, setters, no/all args constructors through its annotations.
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String abbrName;

    @OneToOne
    private Address physicalAddress;

    private int trainingLead;

    @OneToOne
    private Amenity[] amenities;

    @OneToOne
    private Room[] rooms;

    @OneToOne
    private ResourceMetadata resourceMetadata;

    public Building(String name, String abbrName, Address physicalAddress, int trainingLead, Amenity[] amenities, Room[] rooms, ResourceMetadata resourceMetadata) {
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetadata = resourceMetadata;
    }

}