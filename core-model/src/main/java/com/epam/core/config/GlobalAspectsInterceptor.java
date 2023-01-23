package com.epam.core.config;

import com.epam.core.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class GlobalAspectsInterceptor {

    @AfterThrowing(value = "execution(* com.epam.userservice.service.impl.*.*(..))",
            throwing = "e")
    public void userServiceAfterThrowing(JoinPoint joinPoint, EntityNotFoundException e) {
        String message = "User doesn’t exist with given id: " + joinPoint.getArgs()[0];
        log.error(message);
        throw new EntityNotFoundException(message);
    }

    @AfterThrowing(value = "execution(* com.epam.postservice.service.impl.*.*(..))",
            throwing = "e")
    public void postServiceAfterThrowing(JoinPoint joinPoint, EntityNotFoundException e) {
        String message = "Post doesn’t exist with given id: " + joinPoint.getArgs()[0];
        log.error(message);
        throw new EntityNotFoundException(message);
    }
}
