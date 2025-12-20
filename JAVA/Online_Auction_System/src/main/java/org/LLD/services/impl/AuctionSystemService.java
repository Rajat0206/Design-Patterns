package org.LLD.services.impl;

import org.LLD.constants.AuctionStatus;
import org.LLD.data.IAuctionSystem;
import org.LLD.data.IBidRepository;
import org.LLD.data.IUserRepository;
import org.LLD.models.Auction;
import org.LLD.models.Bid;
import org.LLD.models.User;
import org.LLD.services.IAuctionSystemService;
import org.LLD.services.strategies.FinalizeAuctionStrategy;
import org.LLD.services.strategies.ProfitCalculationStrategy;

import java.util.List;
import java.util.Optional;

public class AuctionSystemService implements IAuctionSystemService {

    private final FinalizeAuctionStrategy finalizeAuctionStrategy;
    private final ProfitCalculationStrategy profitCalculationStrategy;
    private final IAuctionSystem auctionSystemRepository;
    private final IBidRepository bidRepository;
    private final IUserRepository userRepository;

    public AuctionSystemService(FinalizeAuctionStrategy finalizeAuctionStrategy, IAuctionSystem auctionSystemRepository, IBidRepository bidRepository, IUserRepository userRepository, ProfitCalculationStrategy profitCalculationStrategy) {
        this.profitCalculationStrategy = profitCalculationStrategy;
        this.finalizeAuctionStrategy = finalizeAuctionStrategy;
        this.auctionSystemRepository = auctionSystemRepository;
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createAuction(Auction auction) {
        auction.setStatus(AuctionStatus.CREATED);
        List<Bid> bids = bidRepository.getBidsByAuctionId(auction.getId());
        auction.setBids(bids);
        auctionSystemRepository.addAuction(auction);
    }

    @Override
    public Optional<User> closeAuction(Long id) {
        if(auctionSystemRepository.getAuctionStatus(id) == AuctionStatus.COMPLETED) {
            throw new IllegalStateException("Auction is already completed");
        }

        List<Bid> bids = bidRepository.getBidsByAuctionId(id);
        Optional<Long> winningBidId = finalizeAuctionStrategy.findWinner(bids);

        if(winningBidId.isPresent()) {
            Optional<Bid> bid = bidRepository.getBidById(winningBidId.get());

            // bidRepository.removeBidsByAuctionId(id);
            auctionSystemRepository.updateAuctionStatus(id, AuctionStatus.COMPLETED);
            Long userId = bid.get().getBuyer_id();

            auctionSystemRepository.setWinner(id, userId);
            auctionSystemRepository.setWinningBidAmount(id, bid.get().getAmount());
            return userRepository.getUserById(userId);
        }

        return Optional.empty();
    }

    @Override
    public Double getProfitOrLoss (Long sellerId, Long auctionId) {
        Optional<User> seller = userRepository.getUserById(sellerId);

        if(seller.isEmpty()) {
            throw new RuntimeException("Seller not found");
        }

        Auction auction = auctionSystemRepository.getAuctionById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        if(auction.getSeller_id() != sellerId) {
            throw new IllegalStateException("Seller is not the owner of the auction");
        }

        return profitCalculationStrategy.calculateProfit(auction);
    }

}
