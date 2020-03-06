package com.rms.dtomodel;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.rms.webmodel.Employee;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatusDTO {

    @NotNull
    private int id;

    @NotNull
    private boolean whiteboardCleaned;

    @NotNull
    private boolean chairsOrdered;

    @NotNull
    private boolean desksCleaned;

    @NotNull
    @CreationTimestamp
    private Timestamp submittedDateTime;

    @NotNull
    private Employee submitter;

    @NotNull
    private String otherNotes;
}