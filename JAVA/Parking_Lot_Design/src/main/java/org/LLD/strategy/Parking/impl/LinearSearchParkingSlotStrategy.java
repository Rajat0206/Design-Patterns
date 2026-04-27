package org.LLD.strategy.Parking.impl;

import org.LLD.entity.ParkingLot;
import org.LLD.entity.ParkingSlot;
import org.LLD.entity.Vehicle;
import org.LLD.strategy.Parking.SlotFindingStrategy;

import java.util.Optional;

public class LinearSearchParkingSlotStrategy implements SlotFindingStrategy {
    @Override
    public Optional<ParkingSlot> findSlot(ParkingLot parkingLot, Vehicle vehicle) {
        for(ParkingSlot parkingSlot : parkingLot.getParkingSlots()) {
            if(parkingSlot.isEmpty() && parkingSlot.isVehicleSupported(vehicle))
                return Optional.of(parkingSlot);
        }
        return Optional.empty();
    }
}
