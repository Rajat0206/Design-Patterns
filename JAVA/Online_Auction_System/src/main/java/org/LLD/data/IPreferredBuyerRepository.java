package org.LLD.data;

public interface IPreferredBuyerRepository {
    Integer getAuctionCountForBuyer(Long buyerId);
    void addAuctionForBuyer(Long buyerId, Long auctionId);
    void removeAuctionForBuyer(Long buyerId, Long auctionId);
    Boolean hasBuyerParticipatedInAuction(Long buyerId, Long auctionId);
    void setPreferredBuyer(Long buyerId, Boolean isPreferred);
}
