package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Address;
import com.gymer.gymer_rest_api.service.implementation.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getById(@PathVariable Integer id) {
        return addressService.get(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewAddress(@RequestBody Address address) {
        return addressService.add(address) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAddress(@RequestBody Address address, @PathVariable Integer id) {
        if (!address.getId().equals(id)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return addressService.update(address) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
