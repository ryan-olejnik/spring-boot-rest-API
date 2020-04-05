package com.somegroup.dao;

import com.somegroup.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private List<Person> DB = new ArrayList<Person>();

    @Override
    public Person insertPerson(UUID id, Person person) {
        Person newPerson = new Person(
                id,
                person.getName(),
                person.getAge(),
                person.getSex()
        );
        DB.add(newPerson);
        return newPerson;
    }

    @Override
    public List<Person> getAllPersons() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id){
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();

    }

    @Override
    public boolean deletePersonById(UUID id) {
        Optional<Person> foundPerson = getPersonById(id);
        if (foundPerson.isEmpty()) {
            return false;
        }
        DB.remove(foundPerson.get());
        return foundPerson.isPresent();

    }
}
