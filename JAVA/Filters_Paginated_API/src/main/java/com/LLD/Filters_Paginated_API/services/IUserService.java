package com.LLD.Filters_Paginated_API.services;

import com.LLD.Filters_Paginated_API.dto.UserRequestDto;
import com.LLD.Filters_Paginated_API.dto.UserResponseDto;

public interface IUserService {
    UserResponseDto getUsers(UserRequestDto userRequest);
}
