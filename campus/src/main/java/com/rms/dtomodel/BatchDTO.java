package com.rms.dtomodel;

import java.time.LocalDate;

import com.rms.webmodel.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {

    private int id;

    private String name;

    private Employee trainer;

    private Employee coTrainer;

    private Employee[] associates;

    private LocalDate startDate;

    private LocalDate endDate;

    private RMDDTO resourceMetadata;
}