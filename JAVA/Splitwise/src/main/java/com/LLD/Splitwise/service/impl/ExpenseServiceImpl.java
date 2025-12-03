package com.LLD.Splitwise.service.impl;

import com.LLD.Splitwise.dto.ExpenseRequestDto;
import com.LLD.Splitwise.dto.ExpenseResponseDto;
import com.LLD.Splitwise.entity.Expense;
import com.LLD.Splitwise.entity.Group;
import com.LLD.Splitwise.entity.User;
import com.LLD.Splitwise.factory.SplitExpenseFactory;
import com.LLD.Splitwise.repository.ExpenseRepository;
import com.LLD.Splitwise.repository.GroupRepository;
import com.LLD.Splitwise.repository.UserRepository;
import com.LLD.Splitwise.service.ExpenseService;
import com.LLD.Splitwise.service.SplitExpenseStrategy;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    GroupRepository groupRepository;
    ExpenseRepository expenseRepository;
    UserRepository userRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addExpense(ExpenseRequestDto expense) {
        SplitExpenseStrategy splitExpenseStrategy = SplitExpenseFactory.getSplitExpenseStrategy(expense.getExpenseType());
        Map<Long, Double> balances = splitExpenseStrategy.splitExpense(expense);

        Group group = groupRepository.getReferenceById(expense.getGroupId());
        Map<User, Double> groupBalances = group.getBalances();
        for(Map.Entry<User, Double> entry : groupBalances.entrySet()) {
            Long userId = entry.getKey().getId();
            if(balances.containsKey(userId)) {
                Double updatedBalance = entry.getValue() + balances.get(userId);
                groupBalances.put(entry.getKey(), updatedBalance);
            }
        }
        groupRepository.save(group);

        Expense groupExpense = Expense.builder()
                .amount(expense.getAmount())
                .paidBy(userRepository.getReferenceById(expense.getPaidByUserId()))
                .group(group)
                .splitAmong(expense.getSplitAmong().entrySet().stream().collect(Collectors.toMap(e -> userRepository.getReferenceById(e.getKey()), Map.Entry::getValue)))
                .expenseType(expense.getExpenseType())
                .description(expense.getDescription())
                .build();

        expenseRepository.save(groupExpense);
    }

    public List<ExpenseResponseDto> settleExpenses(Long groupId) {
        Group group = this.groupRepository.getReferenceById(groupId);
        Map<User, Double> balances = group.getBalances();
        List<ExpenseResponseDto> transactions = new ArrayList<>();

        PriorityQueue<Pair<Double, Long>> minHeap = new PriorityQueue<>((a, b) -> (int) (a.getFirst() - b.getFirst()));      // owe
        PriorityQueue<Pair<Double, Long>> maxHeap = new PriorityQueue<>((a, b) -> (int) (b.getFirst() - a.getFirst()));      // owed

        for(Map.Entry<User, Double> balance : balances.entrySet()) {
            if(balance.getValue() > 0) {
                maxHeap.add(Pair.of(balance.getValue(), balance.getKey().getId()));
            } else if(balance.getValue() < 0) {
                minHeap.add(Pair.of(balance.getValue(), balance.getKey().getId()));
            }

            balances.put(balance.getKey(), 0.0);
        }

        while(!minHeap.isEmpty()) {
            Pair<Double, Long> user1 = maxHeap.remove();
            Pair<Double, Long> user2 = minHeap.remove();

            if(Math.abs(user1.getFirst()) > Math.abs(user2.getFirst())) {
                transactions.add(ExpenseResponseDto.builder().payMoneyToUserId(user1.getSecond()).getMoneyFromUserId(user2.getSecond()).amount(Math.abs(user2.getFirst())).build());
                maxHeap.add(Pair.of(user1.getFirst() + user2.getFirst(), user1.getSecond()));
            } else {
                transactions.add(ExpenseResponseDto.builder().payMoneyToUserId(user1.getSecond()).getMoneyFromUserId(user2.getSecond()).amount(Math.abs(user1.getFirst())).build());
                minHeap.add(Pair.of(user1.getFirst() + user2.getFirst(), user2.getSecond()));
            }
        }

        return transactions;
    }

    public boolean removeExpense(Long expenseId) {
        Expense expense = this.expenseRepository.getReferenceById(expenseId);
        if(expense != null) {
            this.expenseRepository.delete(expense);
        }

        return false;
    }
}
