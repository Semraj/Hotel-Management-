package com.lcwd.userservice.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.NavigableMap;

@Entity
@Table(name = "micro_users")
public class User {
    @Id
    @Column(name = "ID")
    private String UserId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

}
