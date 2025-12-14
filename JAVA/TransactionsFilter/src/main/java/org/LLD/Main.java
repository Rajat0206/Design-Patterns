package org.LLD;

import org.LLD.constants.Comparison;
import org.LLD.criteria.Criteria;
import org.LLD.criteria.filters.ANDFilter;
import org.LLD.criteria.filters.ORFilter;
import org.LLD.criteria.filters.PriceFilter;
import org.LLD.criteria.filters.TimeFilter;
import org.LLD.data.Transaction;
import org.LLD.factories.PriceComparisonFactory;
import org.LLD.factories.TimeComparisonFactory;
import org.LLD.strategies.price.PriceComparisonStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        List<Transaction> transactions = new ArrayList<>();
        // Add transactions to the list
        transactions.add(new Transaction(1L, 1L, LocalDateTime.now(), 200.0));
        transactions.add(new Transaction(2L, 2L, LocalDateTime.now().plusDays(2), 450.0));
        transactions.add(new Transaction(3L, 1L, LocalDateTime.now().minusDays(5), 300.0));
        transactions.add(new Transaction(4L, 3L, LocalDateTime.now(), 150.0));
        transactions.add(new Transaction(5L, 2L, LocalDateTime.now().minusHours(5), 500.0));
        transactions.add(new Transaction(6L, 1L, LocalDateTime.now().plusHours(3), 700.0));
        transactions.add(new Transaction(7L, 3L, LocalDateTime.now().minusDays(1), 250.0));
        transactions.add(new Transaction(8L, 2L, LocalDateTime.now().plusDays(1), 400.0));
        transactions.add(new Transaction(9L, 1L, LocalDateTime.now(), 600.0));
        transactions.add(new Transaction(10L, 4L, LocalDateTime.now().minusHours(10), 350.0));
        transactions.add(new Transaction(11L, 5L, LocalDateTime.now().plusHours(6), 800.0));
        transactions.add(new Transaction(12L, 1L, LocalDateTime.now().minusDays(3), 450.0));
        transactions.add(new Transaction(13L, 3L, LocalDateTime.now(), 550.0));
        transactions.add(new Transaction(14L, 5L, LocalDateTime.now().plusDays(4), 900.0));

        // Some criteria
        Criteria criteria1 = new PriceFilter(PriceComparisonFactory.getPriceComparison(Comparison.GREATER_THAN), 300.0); // Price > 300
        Criteria criteria2 = new PriceFilter(PriceComparisonFactory.getPriceComparison(Comparison.LESS_THAN), 600.0); // Price < 600
        Criteria criteria3 = new PriceFilter(PriceComparisonFactory.getPriceComparison(Comparison.EQUALS), 450.0); // Price = 450
        Criteria criteria4 = new PriceFilter(PriceComparisonFactory.getPriceComparison(Comparison.GREATER_THAN), 700.0); // Price > 700
        Criteria criteria5 = new TimeFilter(TimeComparisonFactory.getTimeComparison(Comparison.LESS_THAN), LocalDateTime.now().minusDays(1)); // Time < now -1 day
        Criteria criteria6 = new TimeFilter(TimeComparisonFactory.getTimeComparison(Comparison.GREATER_THAN), LocalDateTime.now().plusDays(1)); // Time > now +1 day
        Criteria criteria7 = new TimeFilter(TimeComparisonFactory.getTimeComparison(Comparison.EQUALS), LocalDateTime.now()); // Time = now
        Criteria criteria8 = new ANDFilter(List.of(criteria1, criteria2)); // Price > 300 AND Price < 600
        Criteria criteria9 = new ANDFilter(List.of(criteria5, criteria3)); // Time < now -1 day AND Price = 450
        Criteria criteria10 = new ORFilter(List.of(criteria6, criteria4)); // Time > now +1 day OR Price > 700
        Criteria criteria11 = new ORFilter(List.of(criteria7, criteria3)); // Time = now OR Price = 450
        Criteria criteria12 = new ANDFilter(List.of(criteria8, criteria5)); // (Price > 300 AND Price < 600) AND (Time < now -1 day)
        Criteria criteria13 = new ORFilter(List.of(criteria9, criteria10)); // (Time < now -1 day AND Price = 450) OR (Time > now +1 day OR Price > 700)
        Criteria criteria14 = new ANDFilter(List.of(criteria11, criteria12)); // ((Time = now OR Price = 450) AND ((Price > 300 AND Price < 600) AND (Time < now -1 day)))


        // Apply criteria - Filter transactions based on criteria
        System.out.println("Transactions with price greater than 300:" + criteria1.satify(transactions));
        System.out.println("Transactions with price less than 600:" + criteria2.satify(transactions));
        System.out.println("Transactions with price equal to 450:" + criteria3.satify(transactions));
        System.out.println("Transactions with price greater than 700:" + criteria4.satify(transactions));
        System.out.println("Transactions with time less than now minus 1 day:" + criteria5.satify(transactions));
        System.out.println("Transactions with time greater than now plus 1 day:" + criteria6.satify(transactions));
        System.out.println("Transactions with time equal to now:" + criteria7.satify(transactions));
        System.out.println("Transactions with price greater than 300 AND less than 600:" + criteria8.satify(transactions));
        System.out.println("Transactions with time less than now minus 1 day AND price equal to 450:" + criteria9.satify(transactions));
        System.out.println("Transactions with time greater than now plus 1 day OR price greater than 700:" + criteria10.satify(transactions));
        System.out.println("Transactions with time equal to now OR price equal to 450:" + criteria11.satify(transactions));
        System.out.println("Transactions with (price greater than 300 AND less than 600) AND (time less than now minus 1 day):" + criteria12.satify(transactions));
        System.out.println("Transactions with (time less than now minus 1 day AND price equal to 450) OR (time greater than now plus 1 day OR price greater than 700):" + criteria13.satify(transactions));
        System.out.println("Transactions with ((time equal to now OR price equal to 450) AND ((price greater than 300 AND less than 600) AND (time less than now minus 1 day))):" + criteria14.satify(transactions));
    }
}
