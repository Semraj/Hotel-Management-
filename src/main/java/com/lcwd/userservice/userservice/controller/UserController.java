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

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
   }
@PostMapping("/addUsers")
   public ResponseEntity<List<User>> createAllUser(@RequestBody List<User> user){
    List<User> users = userService.saveAllUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(users);
   }
//Getting User
        @GetMapping("/{userId}")
        public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user2 = userService.getUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(user2);
    }
        @GetMapping("/getUsers")
        public ResponseEntity<List<User>> getAllUser () {
            List<User> allUser = userService.getAllUser();
            return ResponseEntity.status(HttpStatus.OK).body(allUser);

        }
    }

