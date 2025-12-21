package com.LLD.Filters_Paginated_API.criteria.filters;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.models.User;

import java.util.List;

public class OccupationFilter implements Criteria {

    private final String occupation;

    public OccupationFilter(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public List<User> satisfyCriteria(List<User> users) {
        return users.stream()
                .filter(user -> user.getOccupation().equalsIgnoreCase(occupation))
                .toList();
    }
}
