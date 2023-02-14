package com.rest.service.RestfulWebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.service.RestfulWebservice.model.Post;
import com.rest.service.RestfulWebservice.model.User;
import com.rest.service.RestfulWebservice.service.UserDaoSerice;
import com.rest.service.RestfulWebservice.exception.UserNotFoundException;
import jakarta.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private MessageSource messageSource;

    private final UserDaoSerice userDaoSerice;

    public UserController(UserDaoSerice userDaoSerice,MessageSource messageSource) {
        this.userDaoSerice = userDaoSerice;
        this.messageSource = messageSource;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoSerice.getAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable Integer id) {
        User user = userDaoSerice.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
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

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userDaoSerice.getUserById(id));

        if(user.isPresent()){
            throw new UserNotFoundException("id" + id);
        }
        return user.get().getPosts();
    }


}
