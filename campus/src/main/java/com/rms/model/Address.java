package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String unitStreet;

    private String city;

    private String state;

    private String zip;

    private String country;

    public Address(String unitStreet, String city, String state, String zip, String country) {
        this.unitStreet = unitStreet;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

}