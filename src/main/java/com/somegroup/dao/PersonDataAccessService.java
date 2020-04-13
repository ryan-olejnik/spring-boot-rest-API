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
    public Person insertPerson(Person person) {
        String sql = "INSERT INTO spring_tutorial.Person (id, name, age, sex) " +
                "VALUES (UUID_TO_BIN(?), ?, ?, ?);";
        Integer response = this.jdbcTemplate.update(
                sql,
                person.getId().toString(),
                person.getName(),
                person.getAge(),
                String.valueOf(person.getSex())
        );

        if (response == 1){
            return person;
        } else {
            return null;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        String sql = "select " +
                "BIN_TO_UUID(id) as id, " +
                "name, " +
                "age, " +
                "sex " +
                "from Person;";
        List<Person> queryResults = this.jdbcTemplate.query(
                sql,
                ((resultSet, i) -> {
                    return new Person(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("sex").charAt(0)
                    );
                })
        );

        return queryResults;
    }

    @Override
    public Person getPersonById(UUID id) {
        String sql = "select BIN_TO_UUID(id) as id, name, age, sex " +
                "from Person " +
                "where id = UUID_TO_BIN(?);";

        List<Person> queryResults = this.jdbcTemplate.query(
                sql,
                new Object[]{id.toString()}, // why this???
                ((resultSet, i) -> {
                    return new Person(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("sex").charAt(0)
                    );
                })
        );

        return queryResults.size() == 1 ? queryResults.get(0) : null;
    }

    @Override
    public Person updatePerson(UUID id, Person updatedPerson) {
        return null;
    }

    @Override
    public boolean deletePersonById(UUID id) {
        return false;
    }
}
