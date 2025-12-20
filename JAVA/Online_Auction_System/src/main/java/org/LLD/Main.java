package org.LLD;

import org.LLD.constants.FinalizeAuctionStrategyType;
import org.LLD.constants.ProfitCalculationStrategyType;
import org.LLD.data.IAuctionSystem;
import org.LLD.data.impl.AuctionRepository;
import org.LLD.data.impl.BidRepository;
import org.LLD.data.impl.BuyerRepository;
import org.LLD.data.impl.SellerRepository;
import org.LLD.factories.FinalizeAuctionFactory;
import org.LLD.factories.ProfitCalculatorFactory;
import org.LLD.models.Auction;
import org.LLD.models.Bid;
import org.LLD.models.User;
import org.LLD.services.IAuctionSystemService;
import org.LLD.services.IBidService;
import org.LLD.services.impl.AuctionSystemService;
import org.LLD.services.impl.BidService;

import java.util.Optional;

public class Main {
    static void main() {
        User buyer1 = User.builder().id(1L).name("John Doe").age(22).build();
        User buyer2 = User.builder().id(2L).name("Jane Smith").age(28).isPreferredBuyer(true).build();
        User buyer3 = User.builder().id(3L).name("Alice Johnson").age(35).build();

        User seller = User.builder().id(4L).name("Bob Brown").age(45).build();

        Auction auction = Auction.builder()
                .id(1L)
                .seller_id(seller.getId())
                .lowest_bid(10.0)
                .highest_bid(50.0)
                .participation_cost(1.0)
                .build();

        Bid bid1 = Bid.builder().id(1L).auction_id(auction.getId()).buyer_id(buyer1.getId()).amount(17.0).build();
        Bid bid2 = Bid.builder().id(2L).auction_id(auction.getId()).buyer_id(buyer2.getId()).amount(15.0).build();
        Bid updated_bid2 = Bid.builder().id(2L).auction_id(auction.getId()).buyer_id(buyer2.getId()).amount(19.0).build();
        Bid bid3 = Bid.builder().id(3L).auction_id(auction.getId()).buyer_id(buyer3.getId()).amount(19.0).build();

        BidRepository bidRepository = new BidRepository();
        BuyerRepository buyerRepository = new BuyerRepository();
        SellerRepository sellerRepository = new SellerRepository();
        AuctionRepository auctionRepository = new AuctionRepository();

        IBidService bidService = new BidService(bidRepository, auctionRepository, buyerRepository);

        IAuctionSystemService auctionSystem = new AuctionSystemService(
                FinalizeAuctionFactory.getStrategy(FinalizeAuctionStrategyType.HIGHEST_UNIQUE_BIDDER),
                auctionRepository,
                bidRepository,
                buyerRepository,
                sellerRepository,
                ProfitCalculatorFactory.getStrategy(ProfitCalculationStrategyType.SIMPLE)
        );

        IAuctionSystemService auctionSystemPreferredBuyer = new AuctionSystemService(
                FinalizeAuctionFactory.getStrategy(FinalizeAuctionStrategyType.PREFERRED_BUYER),
                auctionRepository,
                bidRepository,
                buyerRepository,
                sellerRepository,
                ProfitCalculatorFactory.getStrategy(ProfitCalculationStrategyType.SIMPLE)
        );


        // Driver code
        buyerRepository.addUser(buyer1);
        buyerRepository.addUser(buyer2);
        buyerRepository.addUser(buyer3);
        sellerRepository.addUser(seller);

        auctionSystem.createAuction(auction);
        bidService.creteBid(bid1);
        bidService.creteBid(bid2);
        bidService.updateBid(updated_bid2);
        bidService.creteBid(bid3);

        Optional<User> winner = auctionSystem.closeAuction(auction.getId());
        if(winner.isPresent()) {
            System.out.println("Winner is: " + winner.get().getName() + " with highest unique bid of " + auction.getWinning_bid_amount());
        } else {
            System.out.println("No winner for the auction.");
        }

        Double profitOrLoss = auctionSystem.getProfitOrLoss(seller.getId(), auction.getId());
        System.out.println("Seller's Profit or Loss for the auction: " + profitOrLoss);


        // Second Auction
        User seller2 = User.builder().id(5L).name("Charlie Davis").age(50).build();
        sellerRepository.addUser(seller2);

        Auction auction2 = Auction.builder()
                .id(2L)
                .seller_id(seller2.getId())
                .lowest_bid(5.0)
                .highest_bid(20.0)
                .participation_cost(2.0)
                .build();
        Bid bid4 = Bid.builder().id(4L).auction_id(auction2.getId()).buyer_id(buyer2.getId()).amount(5.0).build();
        Bid bid5 = Bid.builder().id(5L).auction_id(auction2.getId()).buyer_id(buyer3.getId()).amount(25.0).build();

        auctionSystem.createAuction(auction2);
        bidService.creteBid(bid4);
        try {
            bidService.creteBid(bid5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        bidService.withdrawBid(bid4);

        winner = auctionSystem.closeAuction(auction2.getId());
        if(winner.isPresent()) {
            System.out.println("Winner is: " + winner.get().getName() + " with highest unique bid of " + auction.getWinning_bid_amount());
        } else {
            System.out.println("No winner for the auction.");
        }

        profitOrLoss = auctionSystem.getProfitOrLoss(seller2.getId(), auction2.getId());
        System.out.println("Seller's Profit or Loss for the auction: " + profitOrLoss);
    }
}
