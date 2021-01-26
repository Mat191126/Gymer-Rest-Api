package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.implementation.Address;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController extends RestApiController<Address, Integer> {

    @Autowired
    public AddressController(CrudBehaviour<Address, Integer> service) {
        super(service);
    }

}
