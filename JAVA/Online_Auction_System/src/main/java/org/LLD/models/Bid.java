package org.LLD.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    Long id;
    Long auction_id;
    Long buyer_id;
    Double amount;
}
