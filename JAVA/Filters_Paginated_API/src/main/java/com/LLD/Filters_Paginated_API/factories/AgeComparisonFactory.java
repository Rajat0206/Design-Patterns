package com.LLD.Filters_Paginated_API.factories;

import com.LLD.Filters_Paginated_API.constants.Comparison;
import com.LLD.Filters_Paginated_API.strategies.AgeComparisonStrategy;
import com.LLD.Filters_Paginated_API.strategies.impl.EqualsStrategy;
import com.LLD.Filters_Paginated_API.strategies.impl.GreaterThanStrategy;
import com.LLD.Filters_Paginated_API.strategies.impl.LessThanStrategy;

public class AgeComparisonFactory {
    public static AgeComparisonStrategy getAgeComparison(Comparison comparison) {
        return switch (comparison) {
            case Comparison.GREATER_THAN -> new GreaterThanStrategy();
            case Comparison.LESS_THAN -> new LessThanStrategy();
            case Comparison.EQUALS -> new EqualsStrategy();
            default -> throw new IllegalArgumentException("Invalid operation: ");
        };
    }
}
