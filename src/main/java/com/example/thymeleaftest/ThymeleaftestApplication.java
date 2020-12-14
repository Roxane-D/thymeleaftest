package com.example.thymeleaftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ThymeleaftestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleaftestApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplateBuilder builder = new RestTemplateBuilder();
//        return builder.build();
//    }
}
