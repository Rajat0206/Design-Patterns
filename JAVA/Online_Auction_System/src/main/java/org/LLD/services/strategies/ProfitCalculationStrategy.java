package org.LLD.services.strategies;

import org.LLD.models.Auction;

public interface ProfitCalculationStrategy {
    Double calculateProfit(Auction auction);
}
