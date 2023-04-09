package com.example.springcoreadvanced;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCoreAdvancedApplication {

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            System.out.println("say hello");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreAdvancedApplication.class, args);
    }

}
