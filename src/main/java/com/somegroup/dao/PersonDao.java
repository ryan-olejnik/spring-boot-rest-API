package com.somegroup.dao;

import com.somegroup.model.Person;
import java.util.UUID;

// Dao = Data access Object
public interface PersonDao {
      int insertPerson(UUID id, Person person);

      default int insertPerson(Person person) {
          UUID id = UUID.randomUUID();
          return insertPerson(id, person);
      }
}
