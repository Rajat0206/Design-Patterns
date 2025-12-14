package org.LLD.criteria;

import org.LLD.data.Transaction;

import java.util.List;

public interface Criteria {
    List<Transaction> satify(List<Transaction> transactions);
}
