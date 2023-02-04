package com.rest.service.RestfulWebservice.controller;

import com.rest.service.RestfulWebservice.model.PersonV1;
import com.rest.service.RestfulWebservice.model.Name;
import com.rest.service.RestfulWebservice.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/personn")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Rufet Huseynov");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Ugur","Kerimov"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("Rufet Huseynov");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV1 getFirstVersionOfPersonRequestParam1(){
        return new PersonV1("Rufet Huseynov");
    }
}
