package org.LLD.services.strategies;

import org.LLD.models.Auction;
import org.LLD.models.Bid;
import org.LLD.models.User;

import java.util.List;
import java.util.Optional;

public interface FinalizeAuctionStrategy {
    Optional<Long> findWinner(List<Bid> bids);
}
