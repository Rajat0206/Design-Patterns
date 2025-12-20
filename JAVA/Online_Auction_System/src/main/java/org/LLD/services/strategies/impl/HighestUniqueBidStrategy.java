package org.LLD.services.strategies.impl;

import org.LLD.models.Auction;
import org.LLD.models.Bid;
import org.LLD.models.User;
import org.LLD.services.strategies.FinalizeAuctionStrategy;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class HighestUniqueBidStrategy implements FinalizeAuctionStrategy {
    @Override
    public Optional<Long> findWinner(List<Bid> bids) {
        //Counting the frequency of each bid amount
        ConcurrentHashMap<Double, List<Bid>> maxBid = bids.stream()
                                                    .collect(
                                                            Collectors.groupingByConcurrent(
                                                                    Bid::getAmount,
                                                                    ConcurrentHashMap::new,
                                                                    Collectors.toList()
                                                            ));

        return maxBid.entrySet()
                .stream()
                .filter(ele -> ele.getValue().size() == 1)
                .sorted((a, b) -> (int) (b.getKey() - a.getKey()))
                .map(ele -> ele.getValue().get(0).getId())
                .findFirst();
    }
}
