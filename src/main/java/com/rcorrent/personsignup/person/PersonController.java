package com.rcorrent.personsignup.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(path = "/person")

    @ResponseBody

    public Person getPersonById(@RequestAttribute final UUID id) {
        return personService.getPersonById(id);
    }
}
