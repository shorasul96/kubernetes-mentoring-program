package com.epam.userservice.controller;

import com.epam.post.api.dto.PostDto;
import com.epam.user.api.dto.UserDto;
import com.epam.user.api.dto.UserRequestDto;
import com.epam.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
        return ResponseEntity
                .ok(userService.createUser(requestDto.getUsername()));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity
                .ok(userService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity
                .ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateById(@PathVariable Long id,
                                              @Valid @RequestBody UserRequestDto requestDto) {
        return ResponseEntity
                .ok(userService.updateById(id, requestDto.getUsername()));
    }

    @PutMapping("client/{id}")
    public ResponseEntity<PostDto> updatePostAmount(@PathVariable Long id,
                                                    @RequestParam("postId") @Valid @Min(1L) Long postId) {
        return ResponseEntity.ok(userService.updatePostAmount(id, postId));
    }
}
