package com.rcorrent.personsignup.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person insert(final Person person) {
        this.doGenerateInsertValues(person);
        return repository.save(person);
    }

    public Person findById(final UUID id) {
        return repository.findById(id).orElse(null);
    }

    private void doGenerateInsertValues(final Person person) {
        person.setId(UUID.randomUUID());
        person.setCreatedAt(OffsetDateTime.now());
        person.setUpdatedAt(OffsetDateTime.now());
    }

}
