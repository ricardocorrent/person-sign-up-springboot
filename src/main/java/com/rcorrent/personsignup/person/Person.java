package com.rcorrent.personsignup.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name =  "person")
public class Person implements Serializable {

    @NotNull
    private UUID id;

    @NotNull
    @Max(100)
    private String name;

    @NotNull
    @NotEmpty
    @Max(200)
    @Email
    private String email;

}
