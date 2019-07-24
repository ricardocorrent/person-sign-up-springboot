package com.rcorrent.personsignup.person.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class PersonVO implements Serializable {

    private UUID id;

    private String name;

    private String email;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
