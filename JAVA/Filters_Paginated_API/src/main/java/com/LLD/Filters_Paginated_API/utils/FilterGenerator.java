package com.LLD.Filters_Paginated_API.utils;

import com.LLD.Filters_Paginated_API.constants.Comparison;
import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.criteria.filters.*;
import com.LLD.Filters_Paginated_API.dto.UserRequestDto;
import com.LLD.Filters_Paginated_API.factories.AgeComparisonFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterGenerator {
    public static Criteria getFilter(UserRequestDto userRequest) {
        List<Criteria> criteriaList = new java.util.ArrayList<>();
        if(userRequest.getName() != null) {
            criteriaList.add(new NameFilter(userRequest.getName()));
        }
        if(userRequest.getAge() != null) {
            criteriaList.add(new AgeFilter(userRequest.getAge(), AgeComparisonFactory.getAgeComparison(Comparison.EQUALS)));
        }
        if(userRequest.getCity() != null) {
            criteriaList.add(new CityFilter(userRequest.getCity()));
        }
        if(userRequest.getOccupation() != null) {
            criteriaList.add(new OccupationFilter(userRequest.getOccupation()));
        }

        return new ANDFilter(criteriaList);
    }
}
