package com.rest.service.RestfulWebservice.controller;

import com.rest.service.RestfulWebservice.model.PersonV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Rufet Huseynov");
    }
}
