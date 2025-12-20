package org.LLD.services.impl;

import org.LLD.constants.AuctionStatus;
import org.LLD.data.IAuctionSystem;
import org.LLD.data.IBidRepository;
import org.LLD.models.Bid;
import org.LLD.services.IBidService;

import java.util.Optional;

public class BidService implements IBidService {

    private final IBidRepository bidRepository;
    private final IAuctionSystem auctionRepository;

    public BidService(IBidRepository bidRepository, IAuctionSystem auctionRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public void creteBid(Bid bid) {
        if(auctionRepository.getAuctionStatus(bid.getAuction_id()) == AuctionStatus.COMPLETED) {
            throw new IllegalStateException("Bids can't be created for completed auctions");
        }

        Long auctionId = bid.getAuction_id();

        if(auctionRepository.getAuctionStatus(auctionId) == AuctionStatus.CREATED) {
            auctionRepository.updateAuctionStatus(auctionId, AuctionStatus.BIDDING_OPEN);
        }

        this.bidRepository.addBid(bid);
    }

    @Override
    public void updateBid(Bid newBid) {
        if(auctionRepository.getAuctionStatus(newBid.getAuction_id()) != AuctionStatus.BIDDING_OPEN) {
            throw new IllegalStateException("Bids can be updated only when bidding is open");
        }

        this.bidRepository.updateBid(newBid);
    }

    @Override
    public void withdrawBid(Bid bid) {
        if(auctionRepository.getAuctionStatus(bid.getAuction_id()) != AuctionStatus.BIDDING_OPEN) {
            throw new IllegalStateException("Bids can be withdrawn only when bidding is open");
        }

        this.bidRepository.removeBid(bid);
    }
}
