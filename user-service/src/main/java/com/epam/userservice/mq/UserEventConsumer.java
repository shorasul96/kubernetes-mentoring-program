package com.epam.userservice.mq;

import com.epam.core.dto.PostDto;
import com.epam.userservice.service.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserEventConsumer {

    @Autowired
    private UserEventService eventService;

    @RabbitListener(queues = "${spring.rabbitmq.consume_to_user}")
    public void receivedMessage(PostDto dto) {

        if (dto != null) {
            eventService.updateAmountOfPostsByUserId(dto);
        }
        log.info("User Details Received is.. " + dto);
    }
}
