package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.models.User;
import com.LLD.Filters_Paginated_API.strategies.AgeComparisonStrategy;

import java.util.List;

public class AgeFilter implements Criteria {

    private final AgeComparisonStrategy comparisonStrategy;
    private final int age;

    public AgeFilter(int age, AgeComparisonStrategy comparisonStrategy) {
        this.comparisonStrategy = comparisonStrategy;
        this.age = age;
    }

    @Override
    public List<User> satisfyCriteria(List<User> users) {
        return users.stream()
                .filter(user -> comparisonStrategy.compare(this.age, user.getAge()))
                .toList();
    }
}
