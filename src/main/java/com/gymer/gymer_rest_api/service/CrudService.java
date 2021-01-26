package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class CrudService<T, K> implements CrudBehaviour<T, K> {

    protected final CrudRepository<T, K> repository;

    public CrudService(CrudRepository<T, K> repository) {
        this.repository = repository;
    }

    @Override
    public final Iterable<T> getAll() {
        return repository.findAll();
    }

    @Override
    public final Optional<T> get(K id) {
        return repository.findById(id);
    }

    @Override
    public final boolean add(T object) {
        repository.save(object);
        BaseEntityBehaviour<K> baseEntityBehaviour = (BaseEntityBehaviour<K>) object;
        return repository.existsById(baseEntityBehaviour.getId());
    }

}
