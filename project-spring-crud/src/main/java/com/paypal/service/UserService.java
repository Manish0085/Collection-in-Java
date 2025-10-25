package com.paypal.service;

import com.paypal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String name) {
        userRepository.save(name);
    }

    public List<String> getAllUsers() {
        return userRepository.findAll();
    }
}
