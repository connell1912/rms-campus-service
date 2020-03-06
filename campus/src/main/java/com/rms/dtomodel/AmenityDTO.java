package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import com.rms.model.AmenityStatus;
import com.rms.model.AmenityType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmenityDTO {
    
    @NotNull
    private AmenityType type;

    @NotNull
    private AmenityStatus status;

}