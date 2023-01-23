package com.epam.userservice.mq;

import com.epam.core.dto.PostDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.publish_to_post}")
    private String queue;

    public void send(PostDto dto) {
        rabbitTemplate.convertAndSend(queue, dto);
    }
}