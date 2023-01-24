package com.epam.userservice.service.impl;

import com.epam.post.api.dto.PostDto;
import com.epam.post.api.dto.PostEventStatus;
import com.epam.user.api.dto.UserDto;
import com.epam.user.api.exceptions.UserNotFoundException;
import com.epam.userservice.entity.UserEntity;
import com.epam.userservice.repository.UserRepository;
import com.epam.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //    @Autowired
    //    private UserEventProducer eventProducer;

    @Override
    public boolean userExists(Long authorId) {
        if (authorId == null || authorId <= 0L) {
            return false;
        }
        return userRepository.existsById(authorId);
    }

    @Override
    @Transactional
    public UserDto createUser(String username) {
        UserEntity entity = userRepository.save(new UserEntity(username));
        return entity.getDto();
    }

    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id)
                             .map(UserEntity::getDto)
                             .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (this.userExists(id)) {
            userRepository.deleteById(id);
            return;
        }
        throw new UserNotFoundException();
    }

    @Override
    @Transactional
    public UserDto updateById(Long id, String username) {
        UserDto byId = this.getById(id);
        if (byId != null) {
            UserEntity entity = userRepository.save(
                    new UserEntity()
                            .setId(id)
                            .setUsername(username)
                            .setAmountOfPosts(byId.getAmountOfPosts())
            );
            return entity.getDto();
        }
        throw new UserNotFoundException();
    }

    @Override
    @Transactional
    public PostDto updatePostAmount(Long authorId, Long postId) {
        PostDto postDto = new PostDto();
        postDto.setId(postId);
        postDto.setAuthorId(authorId);
        if (this.userExists(authorId)) {
            postDto.setStatus(PostEventStatus.COMPLETED);
            userRepository.updatePostAmountByUserId(authorId);
        } else {
            postDto.setStatus(PostEventStatus.FAILED);
        }
        return postDto;
    }
}
