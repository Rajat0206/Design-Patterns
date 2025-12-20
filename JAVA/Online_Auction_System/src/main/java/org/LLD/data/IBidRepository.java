package org.LLD.data;

import org.LLD.models.Bid;

import java.util.List;
import java.util.Optional;

public interface IBidRepository {
    Optional<Bid> getBidById(Long id);
    void addBid(Bid bid);
    void removeBid(Bid bid);
    List<Bid> getBidsByAuctionId(Long auctionId);
    void updateBid(Bid newBid);
    void removeBidsByAuctionId(Long auctionId);
}
