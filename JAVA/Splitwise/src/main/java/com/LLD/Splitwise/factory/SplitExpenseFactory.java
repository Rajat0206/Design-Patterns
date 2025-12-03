package com.LLD.Splitwise.factory;

import com.LLD.Splitwise.enums.ExpenseType;
import com.LLD.Splitwise.service.SplitExpenseStrategy;
import com.LLD.Splitwise.service.impl.EqualSplitExpense;
import com.LLD.Splitwise.service.impl.PercentageSplitExpense;

public class SplitExpenseFactory {
    public static SplitExpenseStrategy getSplitExpenseStrategy(ExpenseType expenseType) {
        if(expenseType.equals(ExpenseType.EqualSplit)) {
            return new EqualSplitExpense();
        } else if(expenseType.equals(ExpenseType.PercentageSplit)) {
            return new PercentageSplitExpense();
        }
        return null;
    }
}
