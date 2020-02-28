package com.rms.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Building {

    // @SequenceGenerator(name="BuildingID_seq", sequenceName = "BuildingID_seq", initialValue = 1, allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BuildingID_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String abbrName;

    @Column
    // @OneToOne
    private String physicalAddress;

    @Column
    private int trainingLead;

    @Column
    private String amenities;

    @Column
    private String rooms;

    // @Column
    // @OneToOne
    // private ResourceMetadata resourceMetadata;

    public Building() {
    }

    public Building(int id, String name, String abbrName, String physicalAddress, int trainingLead, String amenities, String rooms) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        // this.resourceMetadata = resourceMetadata;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrName() {
        return this.abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getTrainingLead() {
        return this.trainingLead;
    }

    public void setTrainingLead(int trainingLead) {
        this.trainingLead = trainingLead;
    }

    public String getAmenities() {
        return this.amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getRooms() {
        return this.rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    // public ResourceMetadata getResourceMetadata() {
    //     return this.resourceMetadata;
    // }

    // public void setResourceMetadata(ResourceMetadata resourceMetadata) {
    //     this.resourceMetadata = resourceMetadata;
    // }

    public Building id(int id) {
        this.id = id;
        return this;
    }

    public Building name(String name) {
        this.name = name;
        return this;
    }

    public Building abbrName(String abbrName) {
        this.abbrName = abbrName;
        return this;
    }

    public Building physicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }

    public Building trainingLead(int trainingLead) {
        this.trainingLead = trainingLead;
        return this;
    }

    public Building amenities(String amenities) {
        this.amenities = amenities;
        return this;
    }

    public Building rooms(String rooms) {
        this.rooms = rooms;
        return this;
    }

    // public Building resourceMetadata(ResourceMetadata resourceMetadata) {
    //     this.resourceMetadata = resourceMetadata;
    //     return this;
    // }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Building)) {
            return false;
        }
        Building building = (Building) o;
        return id == building.id && Objects.equals(name, building.name) && Objects.equals(abbrName, building.abbrName) && Objects.equals(physicalAddress, building.physicalAddress) && trainingLead == building.trainingLead && Objects.equals(amenities, building.amenities) && Objects.equals(rooms, building.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbrName, physicalAddress, trainingLead, amenities, rooms);
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", abbrName='" + getAbbrName() + "'" +
            ", physicalAddress='" + getPhysicalAddress() + "'" +
            ", trainingLead='" + getTrainingLead() + "'" +
            ", amenities='" + getAmenities() + "'" +
            ", rooms='" + getRooms() + "'" +
            // ", resourceMetadata='" + getResourceMetadata() + "'" +
            "}";
    }

}