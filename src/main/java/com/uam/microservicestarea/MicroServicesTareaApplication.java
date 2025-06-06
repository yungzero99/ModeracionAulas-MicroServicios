package com.uam.microservicestarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.*;


@SpringBootApplication
public class MicroServicesTareaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesTareaApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }

}