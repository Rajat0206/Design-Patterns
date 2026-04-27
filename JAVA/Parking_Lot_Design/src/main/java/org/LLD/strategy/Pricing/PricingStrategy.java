package org.LLD.strategy.Pricing;

import org.LLD.enums.PricingStrategyType;

public interface PricingStrategy {
    Long calculatePrice();
    PricingStrategyType getType();
}
