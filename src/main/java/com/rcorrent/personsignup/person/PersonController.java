package com.rcorrent.personsignup.person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Inject
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    private ResponseEntity<?> insert(@RequestBody final PersonVO personVO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.insert(personVO));
    }

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    private ResponseEntity<?> getPersonById(@PathVariable final UUID id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping(path = "/{id}")
    private ResponseEntity<?> update(@PathVariable final UUID id, @RequestBody final PersonVO personVO) {
        personVO.setId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.update(personVO));
    }

    @GetMapping(path = "/persons")
    private ResponseEntity<?> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.list());
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<?> delete(@PathVariable final UUID id) {
        this.personService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
