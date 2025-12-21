package com.LLD.Filters_Paginated_API.dto;

import com.LLD.Filters_Paginated_API.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private List<User> users;
    private Integer currentPage;
    private Integer currentLimit;
    private Integer nextPage;
    private Integer nextLimit;
    private Boolean hasNext;
}
