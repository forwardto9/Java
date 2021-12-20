package com.example.beta.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.beta")
//@ComponentScan(value = {"com.example.beta"})
@MapperScan("com.example.beta.dao")
public class BetaWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetaWebApplication.class, args);
    }
}
