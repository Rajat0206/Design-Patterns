package org.LLD.entity;

import org.LLD.enums.VehicleType;

public class Vehicle {
    private Long vehicleNumber;

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private VehicleType vehicleType;
}
