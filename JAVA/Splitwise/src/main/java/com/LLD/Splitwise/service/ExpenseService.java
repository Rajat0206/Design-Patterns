package com.LLD.Splitwise.service;

import com.LLD.Splitwise.dto.ExpenseRequestDto;
import com.LLD.Splitwise.dto.ExpenseResponseDto;
import com.LLD.Splitwise.entity.User;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    void addExpense(ExpenseRequestDto expense);
    List<ExpenseResponseDto> settleExpenses(Long groupId);
    boolean removeExpense(Long expenseId);
}
