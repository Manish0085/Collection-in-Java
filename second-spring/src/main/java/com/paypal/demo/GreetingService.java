package com.paypal.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("myBean")
public class GreetingService {

    public void sayHello(){
        System.out.println("Hello from Spring!");
    }
}
