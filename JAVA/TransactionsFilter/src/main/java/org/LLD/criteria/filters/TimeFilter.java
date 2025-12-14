package org.LLD.criteria.filters;

import org.LLD.criteria.Criteria;
import org.LLD.data.Transaction;
import org.LLD.strategies.time.TimeComparisonStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class TimeFilter implements Criteria {
    private final TimeComparisonStrategy timeComparisonStrategy;
    private final LocalDateTime time;

    public TimeFilter(TimeComparisonStrategy timeComparisonStrategy, LocalDateTime time) {
        this.timeComparisonStrategy = timeComparisonStrategy;
        this.time = time;
    }

    @Override
    public List<Transaction> satify(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(transaction -> timeComparisonStrategy.compare(transaction.getTime(), time))
                .toList();
    }
}
