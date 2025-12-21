package com.LLD.Filters_Paginated_API.services.impl;

import com.LLD.Filters_Paginated_API.criteria.Criteria;
import com.LLD.Filters_Paginated_API.dto.UserRequestDto;
import com.LLD.Filters_Paginated_API.dto.UserResponseDto;
import com.LLD.Filters_Paginated_API.iterators.Iterator;
import com.LLD.Filters_Paginated_API.iterators.impl.UserIterator;
import com.LLD.Filters_Paginated_API.models.User;
import com.LLD.Filters_Paginated_API.services.IUserService;
import com.LLD.Filters_Paginated_API.utils.FilterGenerator;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final Iterator<List<User>> userIterator;

    public UserService(Iterator<List<User>> userIterator) {
        this.userIterator = userIterator;
    }

    public UserResponseDto getUsers(UserRequestDto userRequest) {
        List<User> filteredUsers = null;
        Integer currentPage = userRequest.getPage();
        Integer currentLimit = userRequest.getLimit();

        if(currentPage == null) ((UserIterator) userIterator).getCurrentPage();
        if(currentLimit == null) ((UserIterator) userIterator).getLimit();

        if(userRequest.getLimit() != null && userRequest.getPage() != null) {
            filteredUsers = userIterator.next(userRequest.getPage(), userRequest.getLimit());
        } else if(userIterator.hasNext()) {
            if (userRequest.getPage() == null && userRequest.getLimit() != null) {
                filteredUsers = userIterator.next(userRequest.getLimit());
            } else {
                filteredUsers = userIterator.next();
            }
        }

        if(filteredUsers == null) {
            throw new RuntimeException("No users found for the given page and limit");
        }

        filteredUsers = FilterGenerator.getFilter(userRequest).satisfyCriteria(filteredUsers);

        return UserResponseDto.builder()
                .users(filteredUsers)
                .currentPage(currentPage)
                .currentLimit(currentLimit)
                .nextPage(((UserIterator) userIterator).getCurrentPage())
                .nextLimit(((UserIterator) userIterator).getLimit())
                .hasNext(userIterator.hasNext())
                .build();
    }
}
