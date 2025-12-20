package org.LLD.data.impl;

import org.LLD.constants.AuctionStatus;
import org.LLD.data.IAuctionSystem;
import org.LLD.models.Auction;
import org.LLD.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuctionRepository implements IAuctionSystem {
    private final List<Auction> auctions;

    public AuctionRepository() {
        this.auctions = new ArrayList<>();
    }

    @Override
    public void addAuction(Auction auction) {
        this.auctions.add(auction);
    }

    @Override
    public void removeAuction(Auction auction) {
        this.auctions.remove(auction);
    }

    @Override
    public void updateAuctionStatus(Long id, AuctionStatus status) {
        Auction auction = getAuctionById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        auction.setStatus(status);
    }

    @Override
    public AuctionStatus getAuctionStatus(Long id) {
        Auction auction = getAuctionById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        return auction.getStatus();
    }

    @Override
    public Optional<Auction> getAuctionById(Long id) {
        return auctions.stream().filter(auction -> auction.getId().equals(id)).findFirst();
    }

    @Override
    public void setWinner(Long auctionId, Long userId) {
        Auction auction = getAuctionById(auctionId).orElseThrow(() -> new RuntimeException("Auction not found"));
        auction.setWinner_id(userId);
    }

    @Override
    public void setWinningBidAmount(Long auctionId, Double amount) {
        Auction auction = getAuctionById(auctionId).orElseThrow(() -> new RuntimeException("Auction not found"));
        auction.setWinning_bid_amount(amount);
    }
}
