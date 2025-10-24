package com.paypal.demo;


import com.paypal.loose.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.paypal")
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public LifeCycleBean lifeCycleBean(NotificationService service){
        return new LifeCycleBean(service);
    }
}
