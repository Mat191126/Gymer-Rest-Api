package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Address;
import com.gymer.gymer_rest_api.repository.CrudRepositoryBehaviour;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService extends CrudService<Address, Integer> {

    @Autowired
    public AddressService(@Qualifier("addressRepository") CrudRepositoryBehaviour<Address, Integer> repository) {
        super(repository);
    }

    @Override
    public boolean update(Address newAddress) {
        Optional<Address> oldAddressOptional = get(newAddress.getId());
        if (oldAddressOptional.isPresent()) {
            Address oldAddress = oldAddressOptional.get();
            oldAddress.setCity(newAddress.getCity());
            oldAddress.setStreet(newAddress.getStreet());
            oldAddress.setLocalNumber(newAddress.getLocalNumber());
            oldAddress.setZipCode(newAddress.getZipCode());
            add(oldAddress);
            return true;
        }
        return false;
    }

    @Override
    public final boolean delete(Integer id) {
        Optional<Address> object = get(id);
        if (object.isPresent()) {
            Address oldObject = object.get();
            oldObject.setActive(false);
            repository.save(oldObject);
            return true;
        }
        return false;
    }

}
