package com.example.sportnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SportnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportnewsApplication.class, args);
    }

}
