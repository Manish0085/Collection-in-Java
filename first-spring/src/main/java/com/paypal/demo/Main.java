package com.paypal.demo;


import com.paypal.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        GreetingService myBean = (GreetingService) context.getBean("myBean");
        myBean.sayHello();

        UserService userService1 =
                (UserService) context.getBean("UserEmailService");
        userService1.notifyUser("What's up Guys!");

        UserService userService2 =
                (UserService) context.getBean("UserSMSService");
        userService2.notifyUser("What's up Guys!");

    }
}