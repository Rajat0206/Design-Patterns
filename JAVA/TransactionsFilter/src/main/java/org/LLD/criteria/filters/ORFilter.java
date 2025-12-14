package org.LLD.criteria.filters;

import org.LLD.criteria.Criteria;
import org.LLD.data.Transaction;

import java.util.List;

public class ORFilter implements Criteria {
    private final List<Criteria> criteriaList;

    public ORFilter(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Transaction> satify(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(transaction -> criteriaList.stream().anyMatch(criteria -> !criteria.satify(List.of(transaction)).isEmpty()))
                .toList();
    }
}
