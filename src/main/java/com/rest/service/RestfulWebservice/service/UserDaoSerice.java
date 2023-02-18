package com.rest.service.RestfulWebservice.service;

import com.rest.service.RestfulWebservice.model.User;
import com.rest.service.RestfulWebservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class UserDaoSerice {

    private final UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User getUserById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userRepository.findById(id).stream().filter(predicate).findFirst().get();
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }
}
