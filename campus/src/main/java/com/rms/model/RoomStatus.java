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
/**
 * @Author 1912dec16 Java Fullstack Batch
 * 
 * 
 * The RoomStatusClass is a class that stores information about the current status of a room.
 *  This is populated with boolean information that describes how the room has been left
 *  so that orderliness can be kept track of on a regular basis, on a per-room basis.  It also
 *  stores the timestamp of the most recent review of a room, as well as the person who
 *  submitted the review.
 */
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


    public RoomStatus(boolean whiteboardCleaned, boolean chairOrdered, boolean desksCleaned, Timestamp submittedDateTime, int submitterId) {
        this.whiteboardCleaned = whiteboardCleaned;
        this.chairOrdered = chairOrdered;
        this.desksCleaned = desksCleaned;
        this.submittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
    }


}