package com.rcorrent.personsignup.personinformation;

import com.rcorrent.personsignup.persistence.model.BaseModel;
import com.rcorrent.personsignup.person.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "person_information")
public class PersonInformation implements BaseModel {

    @Id
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotNull
    @Max(50)
    private String label;

    @NotNull
    @Max(100)
    private String value;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
