package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
        return user;
    }

    /*POST http://localhost:8080/users
    {
        "id": 4,
            "name": "Hieu",
            "birthDay": "2023-08-29T03:23:09.588+00:00"
    }*/
    @PostMapping("/users")
    public ResponseEntity<Objects> createUser(@RequestBody User user) {
        User saveUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id-" + id);
    }

}
