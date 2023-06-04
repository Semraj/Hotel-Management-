package com.lcwd.userservice.userservice.controller;

import com.lcwd.userservice.userservice.entity.User;
import com.lcwd.userservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//This is a Controller Class
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
// Creating user
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return  new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }
//Getting User
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    //Getting all Users
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        ResponseEntity<User> userResponseEntit = new ResponseEntity<User>(allUser, HttpStatus.OK);
//        return userResponseEntity;
    }
}
