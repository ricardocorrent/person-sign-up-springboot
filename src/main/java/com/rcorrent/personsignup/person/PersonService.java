package com.rcorrent.personsignup.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    @Deprecated
    PersonRepository repository;

    public UUID insert(final Person person) {
        person.setId(UUID.randomUUID());
        return repository.save(person).getId();
    }

    public Person findById(final UUID id) {
        return repository.findById(id).orElse(null);
    }


}
