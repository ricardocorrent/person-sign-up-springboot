package com.rcorrent.personsignup.personinformation;

import com.rcorrent.personsignup.person.Person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class PersonInformation implements Serializable {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String key;

    private String value;
}
