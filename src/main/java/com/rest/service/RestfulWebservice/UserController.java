package com.rest.service.RestfulWebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable String name){
        return new User(String.format("Hello ",name));
    }
}
