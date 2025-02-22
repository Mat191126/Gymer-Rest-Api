package com.gymer.gymer_rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepositoryBehaviour<T, V> extends CrudRepository<T, V> {

    Iterable<T> findAllByActive(boolean active);

    Optional<T> findByIdAndActive(V id, boolean active);

}
