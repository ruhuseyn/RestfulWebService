package com.rest.service.RestfulWebservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.service.RestfulWebservice.model.User;
import com.rest.service.RestfulWebservice.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoSerice {

    private static List<User> list = new ArrayList<>();

    private static int userCount = 0;

    static{
        list.add(new User(++userCount,"Rufet", LocalDate.now().minusYears(30)));
        list.add(new User(++userCount,"Ugur", LocalDate.now().minusYears(25)));
        list.add(new User(++userCount,"Rauf", LocalDate.now().minusYears(20)));
    }


    public List<User> getAll(){
        return list;
    }
    public User getUserById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return (User) predicate;
    }

    public User saveUser(User user){
        user.setId(++userCount);
        list.add(user);
        return user;
    }

    public void deleteUserById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        list.removeIf(predicate);
    }
}
