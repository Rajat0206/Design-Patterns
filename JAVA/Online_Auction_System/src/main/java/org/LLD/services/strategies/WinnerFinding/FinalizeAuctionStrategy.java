package org.LLD.services.strategies.WinnerFinding;

import org.LLD.models.Bid;

import java.util.List;
import java.util.Optional;

public interface FinalizeAuctionStrategy {
    Optional<Long> findWinningBid(List<Bid> bids);
}
