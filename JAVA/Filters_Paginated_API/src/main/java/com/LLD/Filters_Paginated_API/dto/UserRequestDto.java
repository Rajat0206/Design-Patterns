package com.LLD.Filters_Paginated_API.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private Integer limit;
    private Integer page;
    private String name;
    private Integer age;
    private String occupation;
    private String city;
}
