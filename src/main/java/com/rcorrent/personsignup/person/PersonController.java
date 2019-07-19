package com.rcorrent.personsignup.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private Person getPersonById(@PathVariable final UUID id) {
        return personService.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private Response insert(@RequestBody final Person person) {
        return Response
                .status(HttpStatus.OK.value())
                .entity(personService.insert(person))
                .build();
    }
}
