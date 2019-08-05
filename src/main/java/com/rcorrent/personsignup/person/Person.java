package com.rcorrent.personsignup.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rcorrent.personsignup.persistence.model.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person implements BaseModel {

//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @JsonIgnore
    private OffsetDateTime createdAt;

    @JsonIgnore
    private OffsetDateTime updatedAt;

}
