package com.rest.service.RestfulWebservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
@AllArgsConstructor
@RequiredArgsConstructor
public class User1Service implements TestService{

    @Value("${project.name")
    private String name;
    @Override
    public void test() {
        log.info("${t}");
    }
}
