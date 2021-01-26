package com.gymer.gymer_rest_api.service;

import java.util.Optional;

public interface CrudBehaviour<T, K> {

    Iterable<T> getAll();

    Optional<T> get(K id);

    boolean add(T object);

    boolean update(T object);

}
