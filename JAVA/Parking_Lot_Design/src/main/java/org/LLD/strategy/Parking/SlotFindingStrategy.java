package org.LLD.strategy.Parking;

import org.LLD.entity.ParkingLot;
import org.LLD.entity.ParkingSlot;
import org.LLD.entity.Vehicle;

import java.util.Optional;

public interface SlotFindingStrategy {
    Optional<ParkingSlot> findSlot(ParkingLot parkingLot, Vehicle vehicle);
}
