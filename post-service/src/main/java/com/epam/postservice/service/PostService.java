package com.epam.postservice.service;

import com.epam.post.api.dto.PostDto;
import com.epam.post.api.dto.PostRequestDto;

public interface PostService {

    PostDto createPost(PostRequestDto post);

    boolean postExists(Long id);

    PostDto getPostById(Long id);

    void deletePostById(Long id);

    PostDto updatePost(Long id, String updatedText);
}
