package com.rms.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Amenity {

    // @SequenceGenerator(name = "AmenityID_seq", sequenceName = "AmenityID_seq",
    // initialValue = 1, allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "AmenityID_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;

    @Column
    private String status;

    public Amenity() {
    }

    public Amenity(int id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Amenity id(int id) {
        this.id = id;
        return this;
    }

    public Amenity type(String type) {
        this.type = type;
        return this;
    }

    public Amenity status(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Amenity)) {
            return false;
        }
        Amenity amenity = (Amenity) o;
        return id == amenity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, status);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", type='" + getType() + "'" + ", status='" + getStatus() + "'" + "}";
    }

}