package com.LLD.Filters_Paginated_API.strategies.impl;

import com.LLD.Filters_Paginated_API.strategies.AgeComparisonStrategy;
import org.springframework.stereotype.Service;

@Service
public class LessThanStrategy implements AgeComparisonStrategy {
    @Override
    public boolean compare(int age1, int age2) {
        return age1 < age2;
    }
}
