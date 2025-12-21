package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.models.User;

import java.util.List;

public class NameFilter implements Criteria {

    private final String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public List<User> satisfyCriteria(List<User> users) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .toList();
    }
}
