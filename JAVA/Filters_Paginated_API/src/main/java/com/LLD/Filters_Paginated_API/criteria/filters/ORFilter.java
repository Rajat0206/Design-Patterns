package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;

import java.util.List;

public class ORFilter implements Criteria {
    private final List<Criteria> criteriaList;

    public ORFilter(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<com.LLD.Filters_Paginated_API.models.User> satisfyCriteria(List<com.LLD.Filters_Paginated_API.models.User> users) {
        return users.stream()
                .filter(user -> criteriaList.stream()
                        .anyMatch(criteria -> criteria.satisfyCriteria(List.of(user)).size() > 0))
                .toList();
    }
}
