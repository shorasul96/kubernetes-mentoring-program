package com.epam.postservice.entity;

import com.epam.post.api.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = PostEntity.POST_TABLE_NAME)
public class PostEntity {
    static final String POST_TABLE_NAME = "epam_posts";

    @Id
    @GeneratedValue
    private Long id;
    private Long authorId;
    private String text;
    private Date postedAt;

    public PostDto getDto() {
        PostDto dto = new PostDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
