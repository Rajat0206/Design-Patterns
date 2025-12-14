package org.LLD.factories;

import org.LLD.constants.Comparison;
import org.LLD.strategies.price.EqualsStrategy;
import org.LLD.strategies.price.GreaterThanStrategy;
import org.LLD.strategies.price.LessThanStrategy;
import org.LLD.strategies.price.PriceComparisonStrategy;

public class PriceComparisonFactory {
    public static PriceComparisonStrategy getPriceComparison(Comparison comparison) {
        if(comparison.equals(Comparison.EQUALS)) {
            return new EqualsStrategy();
        } else if(comparison.equals(Comparison.GREATER_THAN)) {
            return new GreaterThanStrategy();
        } else if(comparison.equals(Comparison.LESS_THAN)) {
            return new LessThanStrategy();
        } else {
            throw new IllegalArgumentException("Invalid comparison type");
        }
    }
}
