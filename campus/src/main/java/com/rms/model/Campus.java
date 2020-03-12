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
 * The Campus class defines our Campus model. It utilizes JPA to be able to be persisted into our H2 databases
 * and Lombok to have getters, setters, no/all args constructors through its annotations.
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String abbrName;

    @OneToOne
    private Address shippingAddress;

    private int trainingManagerId;

    private int stagingManagerId;

    private int hrLead;

    @OneToOne
    private Building[] buildings;

    private int[] corporateEmployees;

    @OneToOne
    private ResourceMetadata resourceMetadata;
    
    public Campus(FullName name, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, Building[] buildings, int[] corporateEmployees) {
        this.name = name.getName();
        this.abbrName = name.getAbbrName();
        this.shippingAddress = shippingAddress;
        this.trainingManagerId = trainingManagerId;
        this.stagingManagerId = stagingManagerId;
        this.hrLead = hrLead;
        this.buildings = buildings;
        this.corporateEmployees = corporateEmployees;
    }

}