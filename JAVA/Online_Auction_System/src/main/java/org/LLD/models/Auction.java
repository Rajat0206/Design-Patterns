package org.LLD.models;

import lombok.*;
import org.LLD.constants.AuctionStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    Long id;
    Long seller_id;
    Double lowest_bid;
    Double highest_bid;
    Double participation_cost;
    Long winner_id;
    AuctionStatus status;
    Double winning_bid_amount;
    List<Bid> bids;
}
