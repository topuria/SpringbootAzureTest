package com.azure.test.springbootazuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootAzureDemoApplication {

    @GetMapping(name = "/message")
    public String message() {
        return "Deployed and Works Fine!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAzureDemoApplication.class, args);
    }

}
