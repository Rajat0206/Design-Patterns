package org.LLD.services.impl;

import org.LLD.constants.AuctionStatus;
import org.LLD.data.IAuctionSystem;
import org.LLD.data.IBidRepository;
import org.LLD.data.IUserRepository;
import org.LLD.data.impl.BuyerRepository;
import org.LLD.models.Auction;
import org.LLD.models.Bid;
import org.LLD.services.IBidService;

public class BidService implements IBidService {

    private final IBidRepository bidRepository;
    private final IAuctionSystem auctionRepository;
    private final IUserRepository buyerUserRepository;

    public BidService(IBidRepository bidRepository, IAuctionSystem auctionRepository, IUserRepository buyerUserRepository) {
        this.buyerUserRepository = buyerUserRepository;
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public void creteBid(Bid bid) {
        Auction auction = auctionRepository.getAuctionById(bid.getAuction_id())
                .orElseThrow(() -> new IllegalArgumentException("Auction not found"));

        Long auctionId = auction.getId();
        if(auctionRepository.getAuctionStatus(auctionId) == AuctionStatus.COMPLETED) {
            throw new IllegalStateException("Bids can't be created for completed auctions");
        }

        // validations of bid
        if(bid.getAmount() > auction.getHighest_bid() || bid.getAmount() < auction.getLowest_bid()) {
            throw new IllegalArgumentException("Bid amount is out of allowed range");
        }

        if(auctionRepository.getAuctionStatus(auctionId) == AuctionStatus.CREATED) {
            auctionRepository.updateAuctionStatus(auctionId, AuctionStatus.BIDDING_OPEN);
        }

        long buyer_id = bid.getBuyer_id();
        if(((BuyerRepository) buyerUserRepository).hasBuyerParticipatedInAuction(buyer_id, auctionId)) {
            throw new IllegalStateException("Buyer has already placed a bid in this auction");
        }

        ((BuyerRepository) buyerUserRepository).addAuctionForBuyer(buyer_id, auctionId);
        if(((BuyerRepository) buyerUserRepository).getAuctionCountForBuyer(buyer_id) > 2) {
            ((BuyerRepository) buyerUserRepository).setPreferredBuyer(buyer_id, true);
        }

        this.bidRepository.addBid(bid);
    }

    @Override
    public void updateBid(Bid newBid) {
        Auction auction = auctionRepository.getAuctionById(newBid.getAuction_id())
                .orElseThrow(() -> new IllegalArgumentException("Auction not found"));

        if(auctionRepository.getAuctionStatus(auction.getId()) != AuctionStatus.BIDDING_OPEN) {
            throw new IllegalStateException("Bids can be updated only when bidding is open");
        }

        // validations of newBid
        if(newBid.getAmount() > auction.getHighest_bid() || newBid.getAmount() < auction.getLowest_bid()) {
            throw new IllegalArgumentException("Bid amount is out of allowed range");
        }

        this.bidRepository.updateBid(newBid);
    }

    @Override
    public void withdrawBid(Bid bid) {
        if(auctionRepository.getAuctionStatus(bid.getAuction_id()) != AuctionStatus.BIDDING_OPEN) {
            throw new IllegalStateException("Bids can be withdrawn only when bidding is open");
        }

        long buyer_id = bid.getBuyer_id();
        ((BuyerRepository) buyerUserRepository).removeAuctionForBuyer(buyer_id, bid.getAuction_id());
        if(((BuyerRepository) buyerUserRepository).getAuctionCountForBuyer(buyer_id) <= 2) {
            ((BuyerRepository) buyerUserRepository).setPreferredBuyer(buyer_id, false);
        }

        this.bidRepository.removeBid(bid);
    }
}
