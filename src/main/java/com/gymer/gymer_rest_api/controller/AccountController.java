package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Account;
import com.gymer.gymer_rest_api.service.implementation.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getById(@PathVariable Integer id) {
        return accountService.get(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewAccount(@RequestBody Account account) {
        return accountService.add(account) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAccount(@RequestBody Account account, @PathVariable Integer id) {
        if (!account.getId().equals(id)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return accountService.update(account) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
