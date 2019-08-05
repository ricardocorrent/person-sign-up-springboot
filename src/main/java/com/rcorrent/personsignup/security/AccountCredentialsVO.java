package com.rcorrent.personsignup.security;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@JsonPropertyOrder({"id", "name", "email"})
public class AccountCredentialsVO implements Serializable {

    private String userName;

    private String password;

}
