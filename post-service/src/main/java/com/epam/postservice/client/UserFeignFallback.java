package com.epam.postservice.client;

import com.epam.post.api.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient {

    @Override
    public PostDto updatePostAmountByUserId(Long authorId, Long postId) {
        throw new RuntimeException("User service not responding !!!");
    }
}
