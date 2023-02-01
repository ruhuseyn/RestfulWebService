package com.rest.service.RestfulWebservice.model;

public class PersonV2 {

    private String name;

    public PersonV2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                '}';
    }
}
