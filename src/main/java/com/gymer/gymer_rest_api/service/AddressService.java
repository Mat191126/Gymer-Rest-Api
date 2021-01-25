package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.Address;
import com.gymer.gymer_rest_api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements ICrudService<Address, Integer> {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Iterable<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> get(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public void add(Address object) {
        addressRepository.save(object);
    }

    @Override
    public void update(Address object) {
        Optional<Address> oldAddress = get(object.getId());
        if (oldAddress.isPresent()) {
            Address address = oldAddress.get();
            address.setCity(object.getCity());
            address.setStreet(object.getStreet());
            address.setLocalNumber(object.getLocalNumber());
            address.setZipCode(object.getZipCode());
            add(address);
        }
    }
}
