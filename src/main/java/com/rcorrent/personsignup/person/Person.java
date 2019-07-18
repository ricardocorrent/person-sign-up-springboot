package com.rcorrent.personsignup.person;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Person {

    private UUID id;

    private String name;

    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
