package com.epam.user.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "The username is required.")
    private String username;
}
