package org.LLD.factory;

import org.LLD.config.ServerConfig;
import org.LLD.entity.Ticket;
import org.LLD.enums.PricingStrategyType;
import org.LLD.strategy.Pricing.PricingStrategy;
import org.LLD.strategy.Pricing.impl.FixedPricingStrategy;
import org.LLD.strategy.Pricing.impl.HourlyPricingStrategy;

public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategy(PricingStrategyType strategyType, Ticket ticket) {
        if(strategyType.equals(PricingStrategyType.HOURLY)) {
            return new HourlyPricingStrategy(ServerConfig.PRICE_PER_HOUR);
        } else if (strategyType.equals(PricingStrategyType.FIXED)) {
            return new FixedPricingStrategy(ServerConfig.FIXED_PRICE);
        }
        return null;
    }
}
