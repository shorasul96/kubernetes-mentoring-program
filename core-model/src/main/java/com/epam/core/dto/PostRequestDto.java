package com.epam.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostRequestDto extends PostTextRequestDto {
    @Min(value = 1L, message = "The authorId must be positive number & more than 0")
    @NotNull(message = "The authorId required.")
    private Long authorId;
}


