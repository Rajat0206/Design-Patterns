package com.LLD.Splitwise.entity;

import com.LLD.Splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User paidBy;

    @ElementCollection
    @CollectionTable(name = "expense_splits", joinColumns = @JoinColumn(name = "expense_id"))
    @MapKeyColumn(name = "user_id")
    @Column(name = "amount")
    private Map<User, Double> splitAmong;

    private Double amount;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}
