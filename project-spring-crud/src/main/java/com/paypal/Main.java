package com.paypal;


import com.paypal.config.AppConfig;
import com.paypal.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = context.getBean(UserController.class);
        controller.createUser("Alice");
        controller.createUser("Bob");
        controller.createUser("Charlie");
        controller.listUser();

    }
}