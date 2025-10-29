package com.demo.first.app;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    private Map<Integer, User> userDB = new ConcurrentHashMap<>();

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userDB.putIfAbsent(user.getId(), user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        if (!userDB.containsKey(user.getId())){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User Not Found");
        }
        userDB.put(user.getId(), user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        if (!userDB.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        userDB.remove(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Object> getAllUser(){
        if (userDB.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDB.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userDB.get(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
        return ResponseEntity.ok(user);
    }

}
