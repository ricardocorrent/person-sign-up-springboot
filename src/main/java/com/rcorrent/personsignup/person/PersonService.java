package com.rcorrent.personsignup.person;

import com.rcorrent.personsignup.exception.RegisterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person insert(final Person person) {
        this.doGenerateInsertValues(person);
        return repository.save(person);
    }

    public Person findById(final UUID id) {
        return repository.findById(id).orElseThrow(RegisterNotFoundException::new);
    }

    private Person update(final Person person) {
        final Person personFromDb = this.repository
                .findById(person.getId()).orElse(null);

        if (personFromDb != null) {
            this.doGenerateUpdateValues(person, personFromDb);
            return this.repository.save(personFromDb);
        } else {
            throw new RegisterNotFoundException();
        }
    }

    private void delete(final UUID id) {
        final Person personFromDb = this.repository
                .findById(id).orElseThrow(RegisterNotFoundException::new);
        if (personFromDb != null) {
            this.repository.delete(personFromDb);
        }
    }

    private void doGenerateUpdateValues(final Person person, final Person personFromDb) {
        personFromDb.setName(person.getName());
        personFromDb.setEmail(person.getEmail());
        personFromDb.setUpdatedAt(OffsetDateTime.now());
    }

    private void doGenerateInsertValues(final Person person) {
        person.setId(UUID.randomUUID());
        person.setCreatedAt(OffsetDateTime.now());
        person.setUpdatedAt(OffsetDateTime.now());
    }

    public List<Person> list() {
        return (List<Person>) repository.findAll();
    }

}
