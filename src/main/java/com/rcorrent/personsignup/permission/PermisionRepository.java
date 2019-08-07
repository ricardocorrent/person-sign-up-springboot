package com.rcorrent.personsignup.permission;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PermisionRepository extends CrudRepository<Permission, UUID> {
}
