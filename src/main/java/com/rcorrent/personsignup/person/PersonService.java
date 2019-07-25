package com.rcorrent.personsignup.person;

import com.rcorrent.personsignup.converter.DozerConverter;
import com.rcorrent.personsignup.exception.RegisterNotFoundException;
import com.rcorrent.personsignup.person.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Inject
    private PersonRepository repository;

    public PersonVO insert(final PersonVO personVO) {
        final Person person = DozerConverter.parseObject(personVO, Person.class);
        this.doGenerateInsertValues(person);
        return DozerConverter.parseObject(repository.save(person), PersonVO.class);
    }

    public PersonVO findById(final UUID id) {
        return DozerConverter.parseObject(repository.findById(id).orElseThrow(RegisterNotFoundException::new), PersonVO.class);
    }

    public PersonVO update(final PersonVO personVo) {
        final Person personFromDb = this.repository
                .findById(personVo.getId()).orElse(null);

        final Person person = DozerConverter.parseObject(personVo, Person.class);

        if (personFromDb != null) {
            this.doGenerateUpdateValues(person, personFromDb);
            return DozerConverter.parseObject(this.repository.save(personFromDb), PersonVO.class);
        } else {
            throw new RegisterNotFoundException();
        }
    }

    public void delete(final UUID id) {
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

    public List<PersonVO> list() {
        return DozerConverter.parseListObjects ((List<Person>) repository.findAll(), PersonVO.class);
    }

}
