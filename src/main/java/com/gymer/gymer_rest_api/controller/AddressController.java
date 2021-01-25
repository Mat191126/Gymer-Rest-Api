package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Address;
import com.gymer.gymer_rest_api.service.implementation.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public Iterable<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Integer id) {
        return addressService.get(id).orElse(null);
    }

    @PostMapping
    public void addNewAddress(@RequestBody Address address) {
        addressService.add(address);
    }

    @PutMapping("/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable Integer id) {
        address.setId(id);
        addressService.update(address);
    }

}
