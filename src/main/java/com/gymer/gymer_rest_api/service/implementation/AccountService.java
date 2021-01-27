package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Account;
import com.gymer.gymer_rest_api.repository.CrudRepositoryBehaviour;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService extends CrudService<Account, Integer> {

    private final CalendarService calendarService;

    @Autowired
    public AccountService(@Qualifier("accountRepository") CrudRepositoryBehaviour<Account, Integer> repository, CalendarService calendarService) {
        super(repository);
        this.calendarService = calendarService;
    }

    @Override
    public boolean update(Account newAccount) {
        Optional<Account> oldAccountOptional = repository.findById(newAccount.getId());
        if (oldAccountOptional.isPresent()) {
            Account oldAccount = oldAccountOptional.get();
            oldAccount.setFirstName(newAccount.getFirstName());
            oldAccount.setLastName(newAccount.getLastName());
            oldAccount.setEmail(newAccount.getEmail());
            oldAccount.setPassword(newAccount.getPassword());
            oldAccount.setPhoneNumber(newAccount.getPhoneNumber());
            oldAccount.setAge(newAccount.getAge());
            oldAccount.setHeight(newAccount.getHeight());
            oldAccount.setWeight(newAccount.getWeight());
            oldAccount.setAccountType(newAccount.getAccountType());
            oldAccount.setCalendar(newAccount.getCalendar());
            add(oldAccount);
            return true;
        }
        return false;
    }

    @Override
    public final boolean delete(Integer id) {
        Optional<Account> object = get(id);
        if (object.isPresent()) {
            Account oldObject = object.get();
            oldObject.setActive(false);
            calendarService.delete(oldObject.getCalendar().getId());
            repository.save(oldObject);
            return true;
        }
        return false;
    }
}
