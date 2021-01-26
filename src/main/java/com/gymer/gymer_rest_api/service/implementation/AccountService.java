package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.Account;
import com.gymer.gymer_rest_api.repository.AccountRepository;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements CrudService<Account, Integer> {

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
    public boolean add(Account object) {
        accountRepository.save(object);
        return accountRepository.existsById(object.getId());
    }

    @Override
    public boolean update(Account object) {
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
            account.setCalendar(object.getCalendar());
            add(account);
            return true;
        }
        return false;
    }

}
