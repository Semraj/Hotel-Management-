package com.lcwd.userservice.userservice.controller;

import com.lcwd.userservice.userservice.entity.User;
import com.lcwd.userservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return  new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        ResponseEntity<User> userResponseEntity = new ResponseEntity<User>(allUser, HttpStatus.OK);
        return userResponseEntity;
    }
}