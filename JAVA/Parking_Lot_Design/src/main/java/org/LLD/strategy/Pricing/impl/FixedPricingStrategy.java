package org.LLD.strategy.Pricing.impl;

import org.LLD.enums.PricingStrategyType;
import org.LLD.strategy.Pricing.PricingStrategy;

public class FixedPricingStrategy implements PricingStrategy {
    public final Long price;

    public FixedPricingStrategy(Long price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price;
    }

    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.FIXED;
    }
}
