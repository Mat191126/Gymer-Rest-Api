package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.Account;
import com.gymer.gymer_rest_api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements ICrudService<Account, Integer> {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> get(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public void add(Account object) {
        accountRepository.save(object);
    }

    @Override
    public void update(Account object) {
        Optional<Account> oldAccount = get(object.getId());
        if (oldAccount.isPresent()) {
            Account account = oldAccount.get();
            account.setFirstName(object.getFirstName());
            account.setLastName(object.getLastName());
            account.setEmail(object.getEmail());
            account.setPassword(object.getPassword());
            account.setPhoneNumber(object.getPhoneNumber());
            account.setAge(object.getAge());
            account.setHeight(object.getHeight());
            account.setWeight(object.getWeight());
            account.setAccountType(object.getAccountType());
            add(account);
        }
    }
}
