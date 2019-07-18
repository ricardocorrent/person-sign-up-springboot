package com.rcorrent.personsignup.person;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {
    public Person getPersonById(final UUID id) {
        final Person person = new Person();
        person.setId(id);
        person.setName("Name");
        person.setEmail("email");
        return person;
    }

    public UUID insert(final Person person) {
        return null;
    }
}
