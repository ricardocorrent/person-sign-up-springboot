package com.rcorrent.personsignup.personinformation;

import com.rcorrent.personsignup.personinformation.vo.PersonInformationVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.UUID;

@RestController
@RequestMapping("/person-information")
public class PersonInformationController {

    @Inject
    private PersonInformationService personInformationService;

    @PostMapping
    private Response insert(@RequestBody final PersonInformationVO personInformationVO) {
        return Response
                .status(Response.Status.CREATED)
                .entity(personInformationService.insert(personInformationVO))
                .build();
    }

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    private ResponseEntity<?> getPersonById(@PathVariable final UUID id) {
        return ResponseEntity.ok(personInformationService.findById(id));
    }
}
