package org.LLD.entity;

import org.LLD.strategy.Parking.SlotFindingStrategy;

import java.util.List;

public class ParkingLot {
    private List<ParkingSlot> parkingSlots;
    private SlotFindingStrategy slotFindingStrategy;

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
