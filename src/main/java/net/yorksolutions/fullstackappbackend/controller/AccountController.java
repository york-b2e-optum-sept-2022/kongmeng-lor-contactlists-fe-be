package net.yorksolutions.fullstackappbackend.controller;

import net.yorksolutions.fullstackappbackend.dto.NewAccountRequestDTO;
import net.yorksolutions.fullstackappbackend.entity.AccountEntity;
import net.yorksolutions.fullstackappbackend.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountEntity create(@RequestBody NewAccountRequestDTO newAccountRequestDTO) {
        return this.accountService.create(newAccountRequestDTO);
    }

    @GetMapping
    public AccountEntity login(@RequestParam String email, @RequestParam String password) {
        return this.accountService.login(email,password);
    }
}
