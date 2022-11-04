package net.yorksolutions.fullstackappbackend.repository;

import net.yorksolutions.fullstackappbackend.entity.AccountEntity;
import net.yorksolutions.fullstackappbackend.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
    Iterable<Contact> findAllByOwner(AccountEntity owner);
}
