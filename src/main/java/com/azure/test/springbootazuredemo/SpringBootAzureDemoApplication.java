package com.azure.test.springbootazuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootAzureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAzureDemoApplication.class, args);
    }

}
