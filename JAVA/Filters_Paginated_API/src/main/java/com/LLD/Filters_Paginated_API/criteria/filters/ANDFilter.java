package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.models.User;

import java.util.List;

public class ANDFilter implements Criteria {

    private final List<Criteria> criteriaList;

    public ANDFilter(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<User> satisfyCriteria(List<User> users) {
        return users.stream()
                .filter(user -> criteriaList.stream()
                        .allMatch(criteria -> !criteria.satisfyCriteria(List.of(user)).isEmpty()))
                .toList();
    }
}
