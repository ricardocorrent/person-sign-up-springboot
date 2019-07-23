package com.rcorrent.personsignup.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{id}")
    private ResponseEntity<?> getPersonById(@PathVariable final UUID id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping(path = "/{id}")
    private Response update(@PathVariable final UUID id, @RequestBody final Person person) {
        person.setId(id);
        return Response
                .ok()
                .entity(personService.update(person))
                .build();
    }

    @GetMapping(path = "/persons" )
    private Response list(){
        return Response
                .ok()
                .entity(personService.list())
                .build();
    }

    @PostMapping
    private Response insert(@RequestBody final Person person) {
        return Response
                .status(Response.Status.CREATED)
                .entity(personService.insert(person))
                .build();
    }

    @DeleteMapping(path = "/{id}")
    private Response delete(@PathVariable final UUID id) {
        this.personService.delete(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
