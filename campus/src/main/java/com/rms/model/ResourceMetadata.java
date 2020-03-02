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
public class ResourceMetadata{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int resourceCreator;

    @CreationTimestamp
    private Timestamp resourceCreatorDateTime;

    private int lastModifier;

    @CreationTimestamp
    private Timestamp lastModifiedDateTime;

    private int resourceOwner;

    public ResourceMetadata(int resourceCreator, int lastModifier, int resourceOwner) {
        this.resourceCreator = resourceCreator;
        this.lastModifier = lastModifier;
        this.resourceOwner = resourceOwner;
    }

}