package com.LLD.Filters_Paginated_API.controllers.impl;

import com.LLD.Filters_Paginated_API.controllers.IUserController;
import com.LLD.Filters_Paginated_API.dto.UserRequestDto;
import com.LLD.Filters_Paginated_API.dto.UserResponseDto;
import com.LLD.Filters_Paginated_API.models.User;
import com.LLD.Filters_Paginated_API.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements IUserController{

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping()
    public ResponseEntity<UserResponseDto> getUsers(@RequestParam(required = false) Integer age,
                                                    @RequestParam(required = false) Integer limit,
                                                    @RequestParam(required = false) Integer page,
                                                    @RequestParam(required = false) String city,
                                                    @RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String occupation) {
        try {
            // Validation of params and conversion to UserRequestDto before passing to service layer
            UserRequestDto userRequest = UserRequestDto.builder()
                                        .age(age)
                                        .limit(limit)
                                        .page(page)
                                        .city(city)
                                        .name(name)
                                        .occupation(occupation)
                                        .build();

            return ResponseEntity.ok(this.userService.getUsers(userRequest));
        } catch (Exception e) {
            System.out.println("Exception in UserController: " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
