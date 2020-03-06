package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    
    @NotNull
    private String unitStreet;

    @NotNull
    private String city;

    @NotNull
    private String state;
    
    @NotNull
    private String zip;

    @NotNull
    private String country;
}