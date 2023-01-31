package com.rest.service.RestfulWebservice.controller;

import com.rest.service.RestfulWebservice.model.User;
import com.rest.service.RestfulWebservice.service.UserDaoSerice;
import com.rest.service.RestfulWebservice.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserDaoSerice userDaoSerice;

    public UserController(UserDaoSerice userDaoSerice) {
        this.userDaoSerice = userDaoSerice;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoSerice.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
       User user = userDaoSerice.getUserById(id);

       if(user == null){
           throw new UserNotFoundException("id: " +id);
       }
       return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser = userDaoSerice.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userDaoSerice.deleteUserById(id);
    }
}
