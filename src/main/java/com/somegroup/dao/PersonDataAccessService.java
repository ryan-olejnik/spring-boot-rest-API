package com.somegroup.dao;

import com.somegroup.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySql")
public class PersonDataAccessService implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person insertPerson(UUID id, Person person) {
        return null;
    }

    @Override
    public Person insertPerson(Person person) {
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> allPeople = this.jdbcTemplate.query(
                "SELECT * FROM PERSON;",
                ((resultSet, i) -> {
                    return new Person(
                            UUID.randomUUID(),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("sex").charAt(0)
                    );
                })
        );

        return allPeople;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> updatePerson(UUID id, Person updatedPerson) {
        return Optional.empty();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        return false;
    }
}
