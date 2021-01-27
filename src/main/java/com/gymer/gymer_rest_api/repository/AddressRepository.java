package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.implementation.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepositoryBehaviour<Address, Integer> {
}
