package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.implementation.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepositoryBehaviour<Account, Integer> {
}
