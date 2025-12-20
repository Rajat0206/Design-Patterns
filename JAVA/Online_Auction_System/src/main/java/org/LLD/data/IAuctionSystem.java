package org.LLD.data;

import org.LLD.constants.AuctionStatus;
import org.LLD.models.Auction;

import java.util.Optional;

public interface IAuctionSystem {
    void addAuction(Auction auction);
    void removeAuction(Auction auction);
    Optional<Auction> getAuctionById(Long id);
    void updateAuctionStatus(Long id, AuctionStatus status);
    AuctionStatus getAuctionStatus(Long id);
    void setWinner(Long auctionId, Long userId);
    void setWinningBidAmount(Long auctionId, Double amount);
}
