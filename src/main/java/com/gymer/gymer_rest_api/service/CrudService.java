package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import com.gymer.gymer_rest_api.repository.CrudRepositoryBehaviour;

import java.util.Optional;

public abstract class CrudService<T extends BaseEntityBehaviour<K>, K> implements CrudBehaviour<T, K> {

    protected final CrudRepositoryBehaviour<T, K> repository;

    public CrudService(CrudRepositoryBehaviour<T, K> repository) {
        this.repository = repository;
    }

    @Override
    public final Iterable<T> getAll() {
        return repository.findAllByActive(true);
    }

    @Override
    public final Optional<T> get(K id) {
        return repository.findByIdAndActive(id, true);
    }

    @Override
    public final boolean add(T object) {
        repository.save(object);
        return repository.existsById(object.getId());
    }

}
