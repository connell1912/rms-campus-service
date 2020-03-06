package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import com.rms.webmodel.Title;
import com.rms.model.ResourceMetadata;
import com.rms.model.Room;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {

    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private AddressDTO physicAddress;

    @NonNull
    private Title title;

    @NotNull
    private AmenityDTO[] amenities;

    // needs to be a DTO
    @NotNull
    private Room[] rooms;

    // needs to be a DTO
    @NotNull
    private ResourceMetadata resourceMetadata;
}