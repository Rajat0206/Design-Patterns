package org.LLD.services.strategies.ProfitOrLossCalculation.impl;

import org.LLD.models.Auction;
import org.LLD.services.strategies.ProfitOrLossCalculation.ProfitCalculationStrategy;

public class SimpleProfitCalculationStrategy implements ProfitCalculationStrategy {
    @Override
    public Double calculateProfit(Auction auction) {
        double profit = ((double) auction.getBids().size()) * 0.2d * auction.getParticipation_cost();

        if(auction.getWinner_id() != null) {
            profit += auction.getWinning_bid_amount() - ((auction.getHighest_bid() + auction.getLowest_bid())/2.0d);
        }

        return profit;
    }
}
