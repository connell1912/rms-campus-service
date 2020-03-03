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
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean whiteboardCleaned;

    private boolean chairOrdered;

    private boolean desksCleaned;

    private String submittedDateTime;

    private int submitterId;

    public RoomStatus(boolean whiteboardCleaned, boolean chairOrdered, boolean desksCleaned, String submittedDateTime, int submitterId) {
        this.whiteboardCleaned = whiteboardCleaned;
        this.chairOrdered = chairOrdered;
        this.desksCleaned = desksCleaned;
        this.submittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
    }

}