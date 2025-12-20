package org.LLD.services.strategies.WinnerFinding.impl;

import org.LLD.data.IUserRepository;
import org.LLD.data.impl.BuyerRepository;
import org.LLD.models.Bid;
import org.LLD.services.strategies.WinnerFinding.FinalizeAuctionStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PreferredBuyerHighestBidStrategy implements FinalizeAuctionStrategy {
    private final IUserRepository userRepository;

    public PreferredBuyerHighestBidStrategy() {
        this.userRepository = new BuyerRepository();
    }

    @Override
    public Optional<Long> findWinningBid(List<Bid> bids) {
        //Counting the frequency of each bid amount
        ConcurrentHashMap<Double, List<Bid>> maxBid = bids.stream()
                .collect(
                        Collectors.groupingByConcurrent(
                                Bid::getAmount,
                                ConcurrentHashMap::new,
                                Collectors.toList()
                        ));

        List<Map.Entry<Double, List<Bid>>> sortedBids = maxBid.entrySet()
                .stream()
                .sorted((a, b) -> (int) (b.getKey() - a.getKey()))
                .collect(Collectors.toList());

        for (Map.Entry<Double, List<Bid>> entry : sortedBids) {
            List<Bid> bidList = entry.getValue();

            if(bidList.size() == 1) {
                return Optional.of(bidList.get(0).getId());
            }

            // Check for preferred buyers first
            List<Bid> preferredBuyerBids = bidList.stream()
                    .filter(bid -> {
                        return userRepository.getUserById(bid.getBuyer_id())
                                .map(user -> user.getIsPreferredBuyer() != null && user.getIsPreferredBuyer())
                                .orElse(false);
                    })
                    .toList();

            if (preferredBuyerBids.size() == 1) {
                return Optional.of(preferredBuyerBids.get(0).getId());
            }
        }

        return Optional.empty();
    }
}
