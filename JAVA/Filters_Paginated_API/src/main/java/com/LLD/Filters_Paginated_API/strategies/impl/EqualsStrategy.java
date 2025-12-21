package com.LLD.Filters_Paginated_API.strategies.impl;

import com.LLD.Filters_Paginated_API.strategies.AgeComparisonStrategy;

public class EqualsStrategy implements AgeComparisonStrategy {
    @Override
    public boolean compare(int age1, int age2) {
        return age1 == age2;
    }
}
