package com.paypal.config;


import com.paypal.db.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.paypal")
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public DatabaseConnection dbConnection(){
        return new DatabaseConnection();
    }

}
