package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserDaoService userDaoService;
    //http://localhost:8080/user
    @GetMapping("/user")
    public List<User> findAll() {
        return userDaoService.findAll();
    }
    //http://localhost:8080/user/1
    @GetMapping("/user/{id}")
    public User findOneUser(@PathVariable int id) {
        return userDaoService.findOne(id);
    }
}
