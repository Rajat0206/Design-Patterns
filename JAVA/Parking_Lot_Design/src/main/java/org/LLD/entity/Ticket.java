package org.LLD.entity;

import org.LLD.strategy.Payment.PaymentStrategy;
import org.LLD.strategy.Pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Ticket {
    private Long ticketNumber;
    private ParkingSlot parkingSlot;
    private LocalDateTime entryTime;
    private Optional<LocalDateTime> exitTime;
    private Vehicle vehicle;
    private List<PricingStrategy> pricingStrategies;

    public Ticket(ParkingSlot parkingSlot, LocalDateTime entryTime, Optional<LocalDateTime> exitTime, List<PricingStrategy> pricingStrategies, Optional<PaymentStrategy> paymentStrategy, Vehicle vehicle, Long ticketNumber) {
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.pricingStrategies = pricingStrategies;
        this.paymentStrategy = paymentStrategy;
        this.vehicle = vehicle;
        this.ticketNumber = ticketNumber;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Optional<LocalDateTime> getExitTime() {
        return exitTime;
    }

    public void setExitTime(Optional<LocalDateTime> exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<PricingStrategy> getPricingStrategies() {
        return pricingStrategies;
    }

    public void setPricingStrategies(List<PricingStrategy> pricingStrategies) {
        this.pricingStrategies = pricingStrategies;
    }

    public Optional<PaymentStrategy> getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(Optional<PaymentStrategy> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    private Optional<PaymentStrategy> paymentStrategy;
}
