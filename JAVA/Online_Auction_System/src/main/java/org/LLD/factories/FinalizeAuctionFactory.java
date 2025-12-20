package org.LLD.factories;

import org.LLD.constants.FinalizeAuctionStrategyType;
import org.LLD.services.strategies.WinnerFinding.FinalizeAuctionStrategy;
import org.LLD.services.strategies.WinnerFinding.impl.HighestUniqueBidStrategy;
import org.LLD.services.strategies.WinnerFinding.impl.PreferredBuyerHighestBidStrategy;

public class FinalizeAuctionFactory {
    public static FinalizeAuctionStrategy getStrategy(FinalizeAuctionStrategyType strategyType) {
        if(strategyType.equals(FinalizeAuctionStrategyType.HIGHEST_UNIQUE_BIDDER)) {
            return new HighestUniqueBidStrategy();
        } else if(strategyType.equals(FinalizeAuctionStrategyType.PREFERRED_BUYER)) {
            return new PreferredBuyerHighestBidStrategy();
        }
        return null;
    }
}
