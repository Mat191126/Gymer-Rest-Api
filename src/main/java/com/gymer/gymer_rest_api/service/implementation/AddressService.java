package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.Address;
import com.gymer.gymer_rest_api.repository.AddressRepository;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements CrudService<Address, Integer> {

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
    public boolean add(Address object) {
        addressRepository.save(object);
        return addressRepository.existsById(object.getId());
    }

    @Override
    public boolean update(Address object) {
        Optional<Address> oldAddress = get(object.getId());
        if (oldAddress.isPresent()) {
            Address address = oldAddress.get();
            address.setCity(object.getCity());
            address.setStreet(object.getStreet());
            address.setLocalNumber(object.getLocalNumber());
            address.setZipCode(object.getZipCode());
            add(address);
            return true;
        }
        return false;
    }

}
