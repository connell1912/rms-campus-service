package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import com.rms.webmodel.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private AddressDTO physicAddress;

    @NotNull
    private Employee title;

    @NotNull
    private AmenityDTO[] amenities;

    @NotNull
    private RoomDTO[] rooms;

    @NotNull
    private RMDDTO resourceMetadata;
}