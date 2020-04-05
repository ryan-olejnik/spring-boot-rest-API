package com.somegroup.api;

import com.somegroup.model.Person;
import com.somegroup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        Optional<Person> person = personService.getPersonById(id);
        if (person.isPresent()) {
            return person;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person not found"
            );
        }
    }

    @DeleteMapping(path = "{id}")
    public boolean deletePerson(@PathVariable("id") UUID id) {
         if (personService.deletePersonById(id)) {
             return true;
         } else {
             throw new ResponseStatusException(
                     HttpStatus.NOT_FOUND, "Person not found"
             );
         }
    }
}

