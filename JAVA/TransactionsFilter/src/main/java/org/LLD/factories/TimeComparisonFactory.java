package org.LLD.factories;

import org.LLD.constants.Comparison;
import org.LLD.strategies.time.EqualsStrategy;
import org.LLD.strategies.time.GreaterThanStrategy;
import org.LLD.strategies.time.LessThanStrategy;
import org.LLD.strategies.time.TimeComparisonStrategy;

public class TimeComparisonFactory {
    public static TimeComparisonStrategy getTimeComparison(Comparison comparison) {
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
