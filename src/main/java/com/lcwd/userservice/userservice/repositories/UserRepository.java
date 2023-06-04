package com.lcwd.userservice.userservice.repositories;

import com.lcwd.userservice.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
}
