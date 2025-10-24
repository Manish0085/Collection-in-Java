package com.paypal.demo;


import com.paypal.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{

    public static void main(String[] args) {

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationBeanContext.xml");

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
////        GreetingService myBean = (GreetingService) context.getBean("myBean");
//        GreetingService myBean = context.getBean(GreetingService.class);
//        myBean.sayHello();
//
////        UserService userService1 =
////                context.getBean(UserService.class);
////        userService1.notifyUser("What's up Guys!");
////
//        UserService userService2 =
//                context.getBean(UserService.class);
//        userService2.notifyUser("What's up Guys!");


        System.out.println("Starting Spring Application Context");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Retrieving Lifecycle Bean");
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);

        lifeCycleBean.performTask();
        System.out.println("Closing Spring Application Context");
    }
}