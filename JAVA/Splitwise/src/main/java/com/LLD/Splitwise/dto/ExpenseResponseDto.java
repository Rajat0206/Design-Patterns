package com.LLD.Splitwise.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDto {
    private Long payMoneyToUserId;
    private Long getMoneyFromUserId;
    private Double amount;
}
