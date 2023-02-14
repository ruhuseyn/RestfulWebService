package com.rest.service.RestfulWebservice.repository;

import com.rest.service.RestfulWebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
