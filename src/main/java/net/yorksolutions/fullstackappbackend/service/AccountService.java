package net.yorksolutions.fullstackappbackend.service;
import net.yorksolutions.fullstackappbackend.controller.AccountController;
import net.yorksolutions.fullstackappbackend.dto.NewAccountRequestDTO;
import net.yorksolutions.fullstackappbackend.entity.AccountEntity;
import net.yorksolutions.fullstackappbackend.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public AccountEntity create(NewAccountRequestDTO newAccountRequestDTO) {
        try {
            return this.accountRepository.save(new AccountEntity(newAccountRequestDTO.email, newAccountRequestDTO.password,newAccountRequestDTO.firstName,newAccountRequestDTO.lastName));
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public AccountEntity login(String email, String password) {
        Optional<AccountEntity> found = this.accountRepository.findByEmailAndPassword(email,password);
        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }
}
