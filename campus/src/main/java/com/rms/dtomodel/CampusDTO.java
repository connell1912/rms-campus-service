package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import com.rms.webmodel.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusDTO {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String abbrName;

    @NotNull
    private AddressDTO shippingAddress;

    @NotNull
    private Employee trainingManager;

    @NotNull
    private Employee stagingManager;

    @NotNull
    private Employee hrLead;

    @NotNull
    private BuildingDTO[] buildings;

    @NotNull
    private Employee[] corporateEmps;

    @NotNull
    private RMDDTO[] resourceMetadata;
}