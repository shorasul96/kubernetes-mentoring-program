package com.epam.userservice;

import com.epam.core.config.GlobalAspectsInterceptor;
import com.epam.core.config.GlobalExceptionHandler;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@EnableRabbit
@SpringBootApplication
@Import({GlobalExceptionHandler.class, GlobalAspectsInterceptor.class})
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
