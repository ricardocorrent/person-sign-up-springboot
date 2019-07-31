package com.rcorrent.personsignup.personinformation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rcorrent.personsignup.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({"id", "person", "label", "value"})
public class PersonInformationVO implements Serializable {

    private UUID id;

    private Person person;

    private String label;

    private String value;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
