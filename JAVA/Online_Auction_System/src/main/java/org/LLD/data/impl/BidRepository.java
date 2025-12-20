package org.LLD.data.impl;

import org.LLD.data.IBidRepository;
import org.LLD.models.Bid;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BidRepository implements IBidRepository {
    private final ConcurrentHashMap<Long, List<Bid>> bids = new ConcurrentHashMap<>();

    @Override
    public Optional<Bid> getBidById(Long id) {
        for(List<Bid> bidList : bids.values()) {
            for(Bid bid : bidList) {
                if(bid.getId().equals(id)) {
                    return Optional.of(bid);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Bid> getBidsByAuctionId(Long auctionId) {
        if(!bids.containsKey(auctionId)) {
            bids.put(auctionId, new java.util.ArrayList<>());
        }

        return bids.get(auctionId);
    }

    @Override
    public void removeBidsByAuctionId(Long auctionId) {
        bids.remove(auctionId);
    }

    @Override
    public void addBid(Bid bid) {
        Long autionId = bid.getAuction_id();
        bids.get(autionId).add(bid);
    }

    @Override
    public void removeBid(Bid bid) {
        Long autionId = bid.getAuction_id();
        if(bids.containsKey(autionId)) {
            bids.get(autionId).remove(bid);
        }
    }

    @Override
    public void updateBid(Bid newBid) {
        Long autionId = newBid.getAuction_id();
        if (bids.containsKey(autionId)) {
            List<Bid> bidList = bids.get(autionId);
            for (int i = 0; i < bidList.size(); i++) {
                if (bidList.get(i).getId().equals(newBid.getId())) {
                    bidList.set(i, newBid);
                    return;
                }
            }
        }
    }
}
