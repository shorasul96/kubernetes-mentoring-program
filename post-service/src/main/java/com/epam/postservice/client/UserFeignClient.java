package com.epam.postservice.client;

import com.epam.post.api.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userFeign", url = "${spring.application.user_service_url}", fallback = UserFeignFallback.class)
public interface UserFeignClient {

    @PutMapping("client/{id}")
    PostDto updatePostAmountByUserId(@PathVariable Long id, @RequestParam("postId") Long postId);
}
