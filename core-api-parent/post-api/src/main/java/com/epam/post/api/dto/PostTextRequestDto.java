package com.epam.post.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PostTextRequestDto {
    @NotBlank(message = "The text is required.")
    private String text;
}
