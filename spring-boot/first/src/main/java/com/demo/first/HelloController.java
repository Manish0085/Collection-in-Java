package com.demo.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Spring Boot";
    }


    @GetMapping("/user")
    public User getUser(){
        return new User(1, "John Doe", "john@example.com");
    }


}
