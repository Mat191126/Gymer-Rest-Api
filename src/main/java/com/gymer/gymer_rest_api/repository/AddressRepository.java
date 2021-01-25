package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
