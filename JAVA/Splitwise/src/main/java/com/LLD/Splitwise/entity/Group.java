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
@Table(name = "user_groups")
public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<User> users;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

    @ElementCollection
    @CollectionTable(name = "group_balances", joinColumns = @JoinColumn(name = "group_id"))
    @MapKeyColumn(name = "user_id")
    @Column(name = "balance")
    private Map<User, Double> balances;
}
