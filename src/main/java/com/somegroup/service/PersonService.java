package com.somegroup.service;

import com.somegroup.dao.PersonDao;
import com.somegroup.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    final private PersonDao personDao;

    @Autowired
    public PersonService (@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person addPerson(@RequestBody Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public Optional<Person> updatePerson(UUID id, Person updatedPerson) {
        return personDao.updatePerson(id, updatedPerson);
    }

    public boolean deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }
}


