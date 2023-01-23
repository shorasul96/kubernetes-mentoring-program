package com.epam.postservice.service;

import com.epam.core.dto.PostDto;
import com.epam.core.dto.PostRequestDto;

public interface PostService {

    PostDto createPost(PostRequestDto post);

    boolean postExists(Long id);

    PostDto getPostById(Long id);

    void deletePostById(Long id);

    PostDto updatePost(Long id, String updatedText);
}
