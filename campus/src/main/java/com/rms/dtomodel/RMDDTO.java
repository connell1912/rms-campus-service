package com.rms.dtomodel;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.rms.webmodel.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RMDDTO {

    @NotNull
    private Employee resourceCreator;

    @NotNull
    private Timestamp resourceCreationDateTime;

    @NotNull
    private Employee lastModifier;

    @NotNull
    private Timestamp lastModifiedDateTime;

    @NotNull
    private Employee resourceOwner;
}