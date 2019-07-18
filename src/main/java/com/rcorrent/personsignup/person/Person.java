package com.rcorrent.personsignup.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Person implements Serializable {

    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

}
