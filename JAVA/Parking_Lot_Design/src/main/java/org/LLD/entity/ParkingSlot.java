package org.LLD.entity;

import org.LLD.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingSlot {
    private Long slotNumber;
    private List<VehicleType> supportedVehicleTypes;
    private Boolean isEmpty;
    private Optional<Vehicle> vehicle;

    public Long getSlotNumber() {
        return slotNumber;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public Boolean isEmpty() {
        return isEmpty;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public Boolean isVehicleSupported(Vehicle vehicle) {
        for(VehicleType supportedVehicle : supportedVehicleTypes) {
            return supportedVehicle.equals(vehicle.getVehicleType());
        }
        return false;
    }
}
