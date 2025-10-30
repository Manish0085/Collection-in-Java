package com.demo.first.app.service;

import com.demo.first.app.exception.UserNotFoundException;
import com.demo.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {

    private final Map<Integer, User> userDb = new ConcurrentHashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user){
        logger.info("Creating User... info");
        userDb.putIfAbsent(user.getId(), user);
        return user;
    }


    public User updateUser(User user){
        if (!userDb.containsKey(user.getId())){
            logger.error("Error when finding user with Id: {}", user.getId());
            throw  new UserNotFoundException("User with ID: " + user.getId() + " does not exists");
        }
        userDb.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int id){
        if (!userDb.containsKey(id)){
            logger.error("Error when finding user with Id: {}", id);
            throw  new UserNotFoundException("User with ID: " + id + " does not exists");
        }
        userDb.remove(id);
        return true;
    }

    public List<User> getAllUsers() {
        if (userDb.isEmpty())
            throw new NullPointerException("No users found in the database");
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {
        if (!userDb.containsKey(id)){
            logger.error("Error when finding user with Id: {}", id);
            throw  new UserNotFoundException("User with ID: " + id + " does not exists");
        }
        return userDb.get(id);
    }

    public List<User> searchUsers(String name, String email) {
        return userDb.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
