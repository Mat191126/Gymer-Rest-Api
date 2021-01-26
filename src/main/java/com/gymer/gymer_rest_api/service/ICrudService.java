package com.gymer.gymer_rest_api.service;

import java.util.Optional;

public interface ICrudService<T, V> {

    Iterable<T> getAll();

    Optional<T> get(V id);

    boolean add(T object);

    boolean update(T object);

}
