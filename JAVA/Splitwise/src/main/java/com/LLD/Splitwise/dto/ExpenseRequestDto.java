package com.LLD.Splitwise.dto;

import com.LLD.Splitwise.enums.ExpenseType;
import lombok.*;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDto {
    private Long paidByUserId;
    private Double amount;
    private Long groupId;
    private Map<Long, Double> splitAmong;
    private ExpenseType expenseType;
    private String description;
}
