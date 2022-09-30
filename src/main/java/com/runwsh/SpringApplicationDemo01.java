package com.runwsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringApplicationDemo01 {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationDemo01.class,args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
