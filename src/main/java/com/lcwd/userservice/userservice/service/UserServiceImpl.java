package com.lcwd.userservice.userservice.service;

import com.lcwd.userservice.userservice.entity.User;
import com.lcwd.userservice.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.userservice.userservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String UserId) {
//        Optional<User> ById = userRepository.findById(UserId);
//        return UserId;
        return userRepository.findById(UserId).orElseThrow(()-> new ResourceNotFoundException());
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public String updateUser(String user) {
        return null;
    }

    @Override
    public String deleteUser(String id) {
        return null;
    }
}


