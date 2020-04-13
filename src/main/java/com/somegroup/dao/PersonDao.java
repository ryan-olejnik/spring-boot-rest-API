package com.somegroup.dao;

import com.somegroup.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Dao = Data access Object
public interface PersonDao {
      Person insertPerson(Person person);

      List<Person> getAllPersons();

      Person getPersonById(UUID id);

      Person updatePerson(UUID id, Person updatedPerson);

      boolean deletePersonById(UUID id);


}
