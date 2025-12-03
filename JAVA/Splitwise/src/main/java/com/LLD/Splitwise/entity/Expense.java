package com.LLD.Splitwise.entity;

import com.LLD.Splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Group group;
    private User paidBy;
    private Map<User, Double> splitAmong;
    private Double amount;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}
