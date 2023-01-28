package com.rest.service.RestfulWebservice;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoSerice {

    private static List<User> list = new ArrayList<>();

    static{
        list.add(new User(1,"Rufet", LocalDate.now().minusYears(30)));
        list.add(new User(2,"Ugur", LocalDate.now().minusYears(25)));
        list.add(new User(3,"Rauf", LocalDate.now().minusYears(20)));
    }

    public List<User> getAll(){
        return list;
    }
    public User getUserById(Integer id){
        return list.get(id);
    }
}
