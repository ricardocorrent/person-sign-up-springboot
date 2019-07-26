package com.rcorrent.personsignup.personinformation;

import com.rcorrent.personsignup.adapter.DozerAdapter;
import com.rcorrent.personsignup.exception.RegisterNotFoundException;
import com.rcorrent.personsignup.personinformation.vo.PersonInformationVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class PersonInformationService {

    @Inject
    private PersonInformationRepository repository;

    public PersonInformationVO insert(final PersonInformationVO personInformationVO) {
        final PersonInformation personInformation =
                DozerAdapter.parseObject(personInformationVO, PersonInformation.class);
        this.doGenerateInsertValues(personInformation);
        return DozerAdapter.parseObject(repository.save(personInformation), PersonInformationVO.class);
    }

    private void doGenerateInsertValues(final PersonInformation personInformation) {
        personInformation.setId(UUID.randomUUID());
        personInformation.setCreatedAt(OffsetDateTime.now());
        personInformation.setUpdatedAt(OffsetDateTime.now());
    }

    public PersonInformationVO findById(final UUID id) {
        return DozerAdapter.parseObject(
                repository.findById(id)
                        .orElseThrow(RegisterNotFoundException::new), PersonInformationVO.class);
    }
}
