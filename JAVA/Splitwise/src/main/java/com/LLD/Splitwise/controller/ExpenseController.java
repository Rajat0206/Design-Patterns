package com.LLD.Splitwise.controller;

import com.LLD.Splitwise.dto.ExpenseRequestDto;
import com.LLD.Splitwise.dto.ExpenseResponseDto;
import com.LLD.Splitwise.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    ExpenseService expenseService;

    @GetMapping("/settle/{groupId}")
    public ResponseEntity<List<ExpenseResponseDto>> settleExpense(@PathVariable Long groupId) {
        return ResponseEntity.ok(this.expenseService.settleExpenses(groupId));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody ExpenseRequestDto expense) {
        this.expenseService.addExpense(expense);
        return ResponseEntity.ok("Expense added successfully");
    }

    @DeleteMapping("/remove/{expenseId}")
    public ResponseEntity<String> removeExpense(@PathVariable Long expenseId) {
        boolean isRemoved = this.expenseService.removeExpense(expenseId);
        if (isRemoved) {
            return ResponseEntity.ok("Expense removed successfully");
        } else {
            return ResponseEntity.status(404).body("Expense not found");
        }
    }
}
