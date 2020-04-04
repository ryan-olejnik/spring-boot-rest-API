package com.somegroup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;
    private final int age;
    private final char sex;

    public Person(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("age") int age,
            @JsonProperty("sex") char sex
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public UUID getId() {
        return id; // this.id?
    }

    public String getName() {
        return name; // this.name ??
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

}
