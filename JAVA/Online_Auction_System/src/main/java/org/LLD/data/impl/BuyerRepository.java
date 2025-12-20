package org.LLD.data.impl;

import org.LLD.data.IPreferredBuyerRepository;
import org.LLD.data.IUserRepository;
import org.LLD.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BuyerRepository implements IUserRepository, IPreferredBuyerRepository {
    private final List<User> buyers;
    private final ConcurrentHashMap<Long, HashSet<Long>> buyerAuctions = new ConcurrentHashMap<>();

    public BuyerRepository() {
        this.buyers = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.buyers.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.buyers.remove(user);
    }

    @Override
    public Integer getAuctionCountForBuyer(Long buyerId) {
        return buyerAuctions.getOrDefault(buyerId, new HashSet<>()).size();
    }

    @Override
    public void addAuctionForBuyer(Long buyerId, Long auctionId) {
        buyerAuctions.putIfAbsent(buyerId, new HashSet<>());
        buyerAuctions.get(buyerId).add(auctionId);
    }

    @Override
    public void removeAuctionForBuyer(Long buyerId, Long auctionId) {
        if(buyerAuctions.containsKey(buyerId)) {
            buyerAuctions.get(buyerId).remove(auctionId);
        }
    }

    @Override
    public Boolean hasBuyerParticipatedInAuction(Long buyerId, Long auctionId) {
        return buyerAuctions.getOrDefault(buyerId, new HashSet<>()).contains(auctionId);
    }

    @Override
    public void setPreferredBuyer(Long buyerId, Boolean isPreferred) {
        User buyer = getUserById(buyerId).orElseThrow(() -> new IllegalArgumentException("Buyer not found"));
        buyer.setIsPreferredBuyer(isPreferred);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.buyers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
