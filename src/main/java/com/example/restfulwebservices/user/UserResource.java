package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /*POST http://localhost:8080/users
    {
        "id": 4,
            "name": "Hieu",
            "birthDay": "2023-08-29T03:23:09.588+00:00"
    }*/
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userDaoService.save(user);
    }
}
