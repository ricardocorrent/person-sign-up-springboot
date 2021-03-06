package com.rcorrent.personsignup.personinformation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonInformationRepository extends CrudRepository<PersonInformation, UUID> {
}
