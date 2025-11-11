package com.example.first_api.controller;


import com.example.first_api.database.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/get")
public class GreetController {


    @GetMapping("/greet")
    public ResponseEntity<String> getRandomGreet(){
        int index = (int) (Math.random() * Data.QUOTES.size());
        String quote = Data.QUOTES.get(index);
        return ResponseEntity.ok(quote);
    }
}
