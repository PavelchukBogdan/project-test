package com.pavelchuk.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableKafka
public class SecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondApplication.class, args);
    }
}
