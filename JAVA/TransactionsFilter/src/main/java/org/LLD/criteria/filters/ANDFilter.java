package org.LLD.criteria.filters;

import org.LLD.criteria.Criteria;
import org.LLD.data.Transaction;

import java.util.List;

public class ANDFilter implements Criteria {
    private final List<Criteria> criteriaList;

    public ANDFilter(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Transaction> satify(List<Transaction> transactions) {
        return transactions
                    .stream()
                    .filter(transaction -> criteriaList.stream().noneMatch(criteria -> criteria.satify(List.of(transaction)).isEmpty()))
                    .toList();
    }
}
