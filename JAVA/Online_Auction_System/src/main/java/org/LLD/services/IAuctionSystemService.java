package org.LLD.services;

import org.LLD.models.Auction;
import org.LLD.models.User;

import java.util.Optional;

public interface IAuctionSystemService {
    void createAuction(Auction auction);
    Optional<User> closeAuction(Long id);
    Double getProfitOrLoss (Long sellerId, Long auctionId);
}
