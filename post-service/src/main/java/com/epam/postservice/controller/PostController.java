package com.epam.postservice.controller;


import com.epam.post.api.dto.PostDto;
import com.epam.post.api.dto.PostRequestDto;
import com.epam.post.api.dto.PostTextRequestDto;
import com.epam.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok().body(postService.createPost(requestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getByPostId(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @Valid @RequestBody PostTextRequestDto requestDto) {
        return ResponseEntity.ok(postService.updatePost(id, requestDto.getText()));
    }
}
