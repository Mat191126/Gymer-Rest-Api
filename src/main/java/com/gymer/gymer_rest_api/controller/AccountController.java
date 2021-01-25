package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Account;
import com.gymer.gymer_rest_api.service.implementation.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService addressService) {
        this.accountService = addressService;
    }

    @GetMapping
    public Iterable<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Integer id) {
        return accountService.get(id).orElse(null);
    }

    @PostMapping
    public void addNewAccount(@RequestBody Account account) {
        accountService.add(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@RequestBody Account account, @PathVariable Integer id) {
        account.setId(id);
        accountService.update(account);
    }

}
