package com.somegroup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Person {
    private final UUID id;

    @NotBlank
    private final String name;

    @NotNull
    private final int age;

    @NotNull
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
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

}
