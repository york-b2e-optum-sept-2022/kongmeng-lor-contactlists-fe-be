package net.yorksolutions.fullstackappbackend.service;
import net.yorksolutions.fullstackappbackend.dto.NewContactRequestDTO;
import net.yorksolutions.fullstackappbackend.entity.AccountEntity;
import net.yorksolutions.fullstackappbackend.entity.Contact;
import net.yorksolutions.fullstackappbackend.repository.AccountRepository;
import net.yorksolutions.fullstackappbackend.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ContactService {
    ContactRepository contactRepository;
    AccountRepository accountRepository;

    public ContactService(ContactRepository contactRepository, AccountRepository accountRepository) {
        this.contactRepository = contactRepository;
        this.accountRepository = accountRepository;
    }

    public Contact create(NewContactRequestDTO requestDTO) {
        Optional<AccountEntity> account = this.accountRepository.findById(requestDTO.ownerId);
        if (account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return this.contactRepository.save(new Contact(account.get(), requestDTO.name, requestDTO.phoneNumber, requestDTO.email, requestDTO.notes));
    }

    public Iterable<Contact> getContactLists(Long accountId) {
        Optional<AccountEntity> account = this.accountRepository.findById(accountId);
        if (account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return this.contactRepository.findAllByOwner(account.get());
    }

    public void delete(Long contactId) {
        this.contactRepository.deleteById(contactId);
    }
}
