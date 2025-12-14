package org.LLD.criteria.filters;

import org.LLD.criteria.Criteria;
import org.LLD.data.Transaction;
import org.LLD.strategies.price.PriceComparisonStrategy;

import java.util.List;

public class PriceFilter implements Criteria {
    private final PriceComparisonStrategy priceComparisonStrategy;
    private final Double price;

    public PriceFilter(PriceComparisonStrategy priceComparisonStrategy, Double price) {
        this.priceComparisonStrategy = priceComparisonStrategy;
        this.price = price;
    }

    @Override
    public List<Transaction> satify(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(transaction -> priceComparisonStrategy.compare(transaction.getAmount(), price))
                .toList();
    }
}
