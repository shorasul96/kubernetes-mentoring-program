package com.epam.userservice.service;

import com.epam.core.dto.UserDto;

public interface UserService {

    boolean userExists(Long authorId);

    UserDto createUser(String username);

    UserDto getById(Long id);

    void deleteById(Long id);

    UserDto updateById(Long id, String username);
}
