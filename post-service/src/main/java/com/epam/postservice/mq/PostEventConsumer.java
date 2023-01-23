package com.epam.postservice.mq;

import com.epam.core.dto.PostDto;
import com.epam.postservice.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostEventConsumer {

    @Autowired
    private PostService postService;

    @RabbitListener(queues = "${spring.rabbitmq.consume_to_post}")
    public void receivedMessage(PostDto dto) {

        log.info("Post from user-service received: " + dto);
        postService.deletePostById(dto.getId());
    }
}
