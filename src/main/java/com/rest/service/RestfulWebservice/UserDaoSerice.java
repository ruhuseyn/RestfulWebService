package com.rest.service.RestfulWebservice;

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
        return list.stream().filter(predicate).findFirst().orElseThrow(() -> new UserNotFoundException("User yoxdu"));
    }

    public User saveUser(User user){
        user.setId(++userCount);
        list.add(user);
        return user;
    }
}
