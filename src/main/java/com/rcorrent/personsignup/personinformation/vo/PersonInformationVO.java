package com.rcorrent.personsignup.personinformation.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private OffsetDateTime createdAt;

    @JsonIgnore
    private OffsetDateTime updatedAt;

}
