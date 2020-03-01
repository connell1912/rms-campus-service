package com.rms.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    private Timestamp submittedDateTime;

    private int submitterId;

    public RoomStatus(boolean whiteboardCleaned, boolean chairOrdered, boolean desksCleaned) {
        this.whiteboardCleaned = whiteboardCleaned;
        this.chairOrdered = chairOrdered;
        this.desksCleaned = desksCleaned;
    }

}