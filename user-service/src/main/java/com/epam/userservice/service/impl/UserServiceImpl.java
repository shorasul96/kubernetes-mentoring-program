package com.epam.userservice.service.impl;

import com.epam.core.dto.PostDto;
import com.epam.core.dto.UserDto;
import com.epam.core.exceptions.EntityNotFoundException;
import com.epam.userservice.entity.UserEntity;
import com.epam.userservice.mq.UserEventProducer;
import com.epam.userservice.repository.UserRepository;
import com.epam.userservice.service.UserEventService;
import com.epam.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserEventService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEventProducer eventProducer;

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
                             .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (this.userExists(id)) {
            userRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
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
        throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void updateAmountOfPostsByUserId(PostDto dto) {
        Long authorId = dto.getAuthorId();

        if (!this.userExists(authorId)) {
            eventProducer.send(dto);
        } else {
            userRepository.updatePostAmountByUserId(authorId);
        }
    }
}
