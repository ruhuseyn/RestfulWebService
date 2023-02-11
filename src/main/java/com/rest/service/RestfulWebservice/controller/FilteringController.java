package com.rest.service.RestfulWebservice.controller;

import com.rest.service.RestfulWebservice.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue getValue(){
        SomeBean someBean = new SomeBean("value1","value2","value3")
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean)
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public SomeBean getAllValue(){
        return new SomeBean("v","v","v");
    }
}
