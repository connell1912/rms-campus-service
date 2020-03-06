package com.rms.webmodel;

import java.sql.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrder{
    private int id;

    private Timestamp createdDateTime;

    private Timestamp resolvedDateTime;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private String contactEmail;

    private Employee[] creator;

    private Employee[] resolver;
}