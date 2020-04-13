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
    public Person insertPerson(Person person) {

        Person newPerson = new Person(
                UUID.randomUUID(),
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
    public Person getPersonById(UUID id){
//        return DB.stream()
//                .filter(person -> person.getId().equals(id))
//                .findFirst();
        return null;

    }

    @Override
    public Person updatePerson(UUID id, Person updatedPerson) {
//        Optional<Person> maybePerson = getPersonById(id);
//
//        if (maybePerson.isEmpty()) {
//            return maybePerson;
//        }
//
//        DB.set(DB.indexOf(maybePerson.get()), updatedPerson);
//
//        return Optional.of(updatedPerson);
        return null;
    }

    @Override
    public boolean deletePersonById(UUID id) {
//        Optional<Person> maybePerson = getPersonById(id);
//        if (maybePerson.isEmpty()) {
//            return false;
//        }
//        DB.remove(maybePerson.get());
//        return maybePerson.isPresent();
        return true;
    }
}
