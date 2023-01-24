package com.epam.user.api.config;

import com.epam.user.api.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class UserAspectsInterceptor {

    @AfterThrowing(value = "execution(* com.epam.userservice.service.impl.*.*(..))",
            throwing = "e")
    public void userServiceAfterThrowing(JoinPoint joinPoint, UserNotFoundException e) {
        String message = "User doesn’t exist with given id: " + joinPoint.getArgs()[0];
        log.error(message);
        throw new UserNotFoundException(message);
    }
}
