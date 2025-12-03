package com.LLD.Splitwise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<User> users;
    @OneToMany
    private List<Expense> expenses;
    private Map<User, Double> balances;
}
