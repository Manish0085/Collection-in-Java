package com.paypal.loose;

public class EmailService implements NotificationService{

    @Override
    public void send(String msg) {
        System.out.println("EMAIL: " + msg);
    }
}
