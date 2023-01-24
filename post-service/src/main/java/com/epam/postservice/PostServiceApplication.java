package com.epam.postservice;


import com.epam.post.api.config.PostAspectsInterceptor;
import com.epam.post.api.config.PostExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients
@SpringBootApplication
@Import({PostExceptionHandler.class, PostAspectsInterceptor.class})
public class PostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }
}
