package com.somegroup.dao;

import com.somegroup.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        System.out.println("Got a new Person!!!");

        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
