package com.LLD.Splitwise.service;

import com.LLD.Splitwise.dto.ExpenseRequestDto;

import java.util.Map;

public interface SplitExpenseStrategy {
    Map<Long, Double> splitExpense(ExpenseRequestDto expense);
}
