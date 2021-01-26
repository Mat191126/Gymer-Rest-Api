package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.implementation.Account;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController extends RestApiController<Account, Integer> {

    @Autowired
    public AccountController(CrudBehaviour<Account, Integer> service) {
        super(service);
    }

}
