package org.LLD.service;

import org.LLD.entity.ParkingLot;
import org.LLD.entity.ParkingSlot;
import org.LLD.entity.Ticket;
import org.LLD.strategy.Parking.SlotFindingStrategy;

import java.util.HashMap;

public class ParkingLotService {
    private final ParkingLot parkingLot;
    private final SlotFindingStrategy slotFindingStrategy;
    private final HashMap<String, ParkingSlot> vehicleSlotMap = new HashMap<>();
    private final HashMap<String, Ticket> vehicleTicketMap = new HashMap<>();

    public ParkingLotService(ParkingLot parkingLot, SlotFindingStrategy slotFindingStrategy) {
        this.parkingLot = parkingLot;
        this.slotFindingStrategy = slotFindingStrategy;
    }
}
