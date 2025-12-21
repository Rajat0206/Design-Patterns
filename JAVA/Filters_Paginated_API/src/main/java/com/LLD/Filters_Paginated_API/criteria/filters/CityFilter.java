package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.models.User;

import java.util.List;

public class CityFilter implements Criteria {

    private final String city;

    public CityFilter(String city) {
        this.city = city;
    }

    @Override
    public List<User> satisfyCriteria(List<User> users) {
        return users.stream()
                .filter(user -> user.getCity().equalsIgnoreCase(this.city))
                .toList();
    }
}
