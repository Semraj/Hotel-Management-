package com.lcwd.userservice.userservice.service;

import com.lcwd.userservice.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User saveUser(User user);
    User getUser(String id);

    List<User> getAllUser();
    String updateUser(String userId);
    String deleteUser(String Userid);
}
