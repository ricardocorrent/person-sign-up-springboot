package com.rcorrent.personsignup.person;

import com.rcorrent.personsignup.person.vo.PersonVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    private ResponseEntity<?> getPersonById(@PathVariable final UUID id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping(path = "/{id}")
    private Response update(@PathVariable final UUID id, @RequestBody final PersonVO personVO) {
        personVO.setId(id);
        return Response
                .ok()
                .entity(personService.update(personVO))
                .build();
    }

    @GetMapping(path = "/persons")
    private Response list() {
        return Response
                .ok()
                .entity(personService.list())
                .build();
    }

    @PostMapping
    private ResponseEntity<?> insert(@RequestBody final PersonVO personVO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.insert(personVO));
    }

    @DeleteMapping(path = "/{id}")
    private Response delete(@PathVariable final UUID id) {
        this.personService.delete(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
