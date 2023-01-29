package com.rest.service.RestfulWebservice;

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
        return userDaoSerice.getUserById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userDaoSerice.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
