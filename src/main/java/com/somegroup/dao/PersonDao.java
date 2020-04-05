package com.somegroup.dao;

import com.somegroup.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Dao = Data access Object
public interface PersonDao {
      Person insertPerson(UUID id, Person person);

      default Person insertPerson(Person person) {
          UUID id = UUID.randomUUID();
          return insertPerson(id, person);
      }

      List<Person> getAllPersons();

      Optional<Person> getPersonById(UUID id);

      boolean deletePersonById(UUID id);
}
