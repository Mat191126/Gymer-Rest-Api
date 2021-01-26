package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.Account;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController extends RestApiController<Account, Integer> {

    public AccountController(CrudService<Account, Integer> service) {
        super(service);
    }

}
