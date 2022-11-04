package net.yorksolutions.fullstackappbackend.controller;
import net.yorksolutions.fullstackappbackend.dto.NewContactRequestDTO;
import net.yorksolutions.fullstackappbackend.entity.Contact;
import net.yorksolutions.fullstackappbackend.service.AccountService;
import net.yorksolutions.fullstackappbackend.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public Contact create(@RequestBody NewContactRequestDTO requestDTO) {
        return this.contactService.create(requestDTO);
    }
    @GetMapping
    public Iterable<Contact> getContactLists(@RequestParam Long accountId) {
        return this.contactService.getContactLists(accountId);
    }
    @DeleteMapping
    public void delete(@RequestParam Long contactId) {
        this.contactService.delete(contactId);
    }

}
