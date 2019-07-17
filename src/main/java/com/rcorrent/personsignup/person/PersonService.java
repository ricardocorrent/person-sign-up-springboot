package com.rcorrent.personsignup.person;

import java.util.UUID;

public class PersonService {
    public Person getPersonById(final UUID id) {
        final Person person = new Person();
        person.setId(id);
        person.setName("Name");
        person.setEmail("email");
        return person;
    }
}
