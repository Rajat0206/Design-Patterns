package com.LLD.Splitwise.service.impl;

import com.LLD.Splitwise.dto.ExpenseRequestDto;
import com.LLD.Splitwise.service.SplitExpenseStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EqualSplitExpense implements SplitExpenseStrategy {
    @Override
    public Map<Long, Double> splitExpense(ExpenseRequestDto expense) {
        Map<Long, Double> splitAmong = expense.getSplitAmong();
        Map<Long, Double> balances = new HashMap<>();

        Long paidBy = expense.getPaidByUserId();
        Double totalAmount = expense.getAmount();
        Double equalShare = totalAmount / splitAmong.size();

        for(Long id : splitAmong.keySet()) {
            balances.put(id, (id == paidBy ? (totalAmount - equalShare) : -equalShare));
        }
        return balances;
    }
}
