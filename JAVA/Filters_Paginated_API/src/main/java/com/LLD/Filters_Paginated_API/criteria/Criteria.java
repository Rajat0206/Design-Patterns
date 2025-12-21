package com.LLD.Filters_Paginated_API.criteria;

import com.LLD.Filters_Paginated_API.models.User;

import java.util.List;

public interface Criteria {
    List<User> satisfyCriteria(List<User> users);
}
