package org.LLD.strategy.Pricing.impl;

import org.LLD.enums.PricingStrategyType;
import org.LLD.strategy.Pricing.PricingStrategy;

public class HourlyPricingStrategy implements PricingStrategy {
    public final Long pricePerHour;
    public Integer numberOfHours;

    public HourlyPricingStrategy(Long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public HourlyPricingStrategy(Long pricePerHour, Integer numberOfHours) {
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }


    @Override
    public Long calculatePrice() {
        return numberOfHours * pricePerHour;
    }

    public void setNumberOfHours(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.HOURLY;
    }
}
