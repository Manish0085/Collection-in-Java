package com.paypal.loose;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSService implements NotificationService{

    @Override
    public void send(String msg) {
        System.out.println("SMS: " + msg);
    }
}
