package com.rest.service.RestfulWebservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

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
    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        userDaoSerice.saveUser(user);
    }
}
