package com.epam.post.api.config;

import com.epam.post.api.exceptions.PostNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class PostAspectsInterceptor {


    @AfterThrowing(value = "execution(* com.epam.postservice.service.impl.*.*(..))",
            throwing = "e")
    public void postServiceAfterThrowing(JoinPoint joinPoint, PostNotFoundException e) {
        String message = "Post doesn’t exist with given id: " + joinPoint.getArgs()[0];
        log.error(message);
        throw new PostNotFoundException(message);
    }
}
