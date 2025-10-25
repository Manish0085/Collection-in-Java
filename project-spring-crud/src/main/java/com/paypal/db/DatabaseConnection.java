package com.paypal.db;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class DatabaseConnection {

    List<String> users;

    public void init(){
        users = new ArrayList<>();
        System.out.println("DB Connected (Simulated)");
    }


    public List<String> getUsers(){
        return users;
    }

    public void addUser(String user){
        users.add(user);
    }

    public void cleanup(){
        System.out.println("DB Disconnected");
    }
}
