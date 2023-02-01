package com.rest.service.RestfulWebservice.controller;

import com.rest.service.RestfulWebservice.model.PersonV1;
import com.rest.service.RestfulWebservice.model.Name;
import com.rest.service.RestfulWebservice.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Rufet Huseynov");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Ugur","Kerimov"));
    }
}
