package net.yorksolutions.fullstackappbackend.repository;

import net.yorksolutions.fullstackappbackend.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {
    Optional<AccountEntity> findByEmailAndAndPassword(String email, String password);
}
