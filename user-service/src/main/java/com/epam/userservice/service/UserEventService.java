package com.epam.userservice.service;

import com.epam.core.dto.PostDto;

public interface UserEventService {

    void updateAmountOfPostsByUserId(PostDto dto);
}
