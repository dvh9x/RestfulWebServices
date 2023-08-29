package com.example.restfulwebservices.HelloWorld;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}