package com.rms.dtomodel;

import javax.validation.constraints.NotNull;

import com.rms.model.ResourceMetadata;
import com.rms.model.RoomStatus;
import com.rms.webmodel.WorkOrder;

import org.hibernate.engine.jdbc.batch.spi.Batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO{

    @NotNull
    private int id;

    @NotNull
    private String roomNumber;

    @NotNull
    private int maxOccupancy;

    @NotNull
    private boolean isActive;

    @NotNull
    private RoomStatus[] currentStatus;

    @NotNull
    private Batch[] batch;

    @NotNull
    private WorkOrder[] workOrders;

    @NotNull
    private ResourceMetadata[] resourceMetadata;
}