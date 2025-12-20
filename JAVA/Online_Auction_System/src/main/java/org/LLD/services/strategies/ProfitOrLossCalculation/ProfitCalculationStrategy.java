package org.LLD.services.strategies.ProfitOrLossCalculation;

import org.LLD.models.Auction;

public interface ProfitCalculationStrategy {
    Double calculateProfit(Auction auction);
}
