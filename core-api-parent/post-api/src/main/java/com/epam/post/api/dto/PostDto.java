package com.epam.post.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PostDto {
    private Long id;
    private Long authorId;
    private String text;
    private Date postedAt;

    private PostEventStatus status;
}
