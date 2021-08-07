package com.greenzoo.resttdd.greenzooresttdd;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreenzooResttddApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenzooResttddApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
