package com.example.sportnews.web.beans;


import com.example.sportnews.core.NewsService;
import com.example.sportnews.core.UserService;
import com.example.sportnews.repositories.NewsRepository;
import com.example.sportnews.repositories.UserRepository;
import org.springframework.context.annotation.Bean;

public class CoreBeans {
    @Bean
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }
    @Bean
    public NewsService newsService(NewsRepository repository) {
        return new NewsService(repository);
    }

}
