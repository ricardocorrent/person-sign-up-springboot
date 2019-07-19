package com.rcorrent.personsignup.person;

import com.rcorrent.personsignup.persistence.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name =  "person")
public class Person implements BaseModel {

    @NotNull
    @Id
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
