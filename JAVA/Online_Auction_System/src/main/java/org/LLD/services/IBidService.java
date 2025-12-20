package org.LLD.services;

import org.LLD.models.Bid;

public interface IBidService {
    void creteBid(Bid bid);
    void updateBid(Bid newBid);
    void withdrawBid(Bid bid);
}
