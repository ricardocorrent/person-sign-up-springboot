package com.rcorrent.personsignup.person;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({"id", "name", "email"})
public class PersonVO implements Serializable {

    private UUID id;

    private String name;

    private String email;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
