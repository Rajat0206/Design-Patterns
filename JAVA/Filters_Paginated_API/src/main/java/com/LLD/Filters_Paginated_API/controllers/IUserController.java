package com.LLD.Filters_Paginated_API.controllers;

import com.LLD.Filters_Paginated_API.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;


public interface IUserController {
    ResponseEntity<UserResponseDto> getUsers(Integer age, Integer limit, Integer page, String city, String name, String occupation);
}
