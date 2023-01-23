package com.epam.postservice.service.impl;

import com.epam.core.dto.PostDto;
import com.epam.core.dto.PostRequestDto;
import com.epam.core.exceptions.EntityNotFoundException;
import com.epam.postservice.entity.PostEntity;
import com.epam.postservice.mq.PostEventProducer;
import com.epam.postservice.repository.PostRepository;
import com.epam.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostEventProducer eventProducer;

    @Override
    @Transactional
    public PostDto createPost(PostRequestDto post) {
        PostEntity entity = new PostEntity()
                .setAuthorId(post.getAuthorId())
                .setText(post.getText())
                .setPostedAt(new Date());
        PostEntity createdPost = postRepository.save(entity);

        eventProducer.send(createdPost.getDto());
        return createdPost.getDto();
    }

    @Override
    public boolean postExists(Long id) {
        if (id == null || id <= 0L) {
            return false;
        }
        return postRepository.existsById(id);
    }

    @Override
    public PostDto getPostById(Long id) {
        return postRepository.findById(id)
                             .map(PostEntity::getDto)
                             .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public void deletePostById(Long id) {
        if (postExists(id)) {
            postRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public PostDto updatePost(Long id, String updatedText) {
        return postRepository.findById(id).map(postEntity -> {
            postEntity.setText(updatedText);
            postEntity.setPostedAt(new Date());
            return postRepository.save(postEntity).getDto();
        }).orElseThrow(EntityNotFoundException::new);
    }
}
