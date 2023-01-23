package com.epam.userservice.entity;

import com.epam.core.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = UserEntity.USER_TABLE)
public class UserEntity {

    public static final String USER_TABLE = "epam_users";

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int amountOfPosts;

    public UserEntity(String username) {
        this.username = username;
    }

    public UserDto getDto() {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
