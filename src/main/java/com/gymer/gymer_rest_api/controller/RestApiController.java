package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.IdObtainable;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public abstract class RestApiController<T, K> {

    protected static final Logger log = LogManager.getLogger();

    private final CrudBehaviour<T, K> service;

    public RestApiController(CrudBehaviour<T, K> service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    protected final Iterable<T> getAll() {
        log.debug(HttpStatus.OK);
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    protected final T getById(@PathVariable K id) {
        return service.get(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    protected final T addNewAccount(@RequestBody T object) {
        if (service.add(object)) {
            return object;
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    protected final void updateAccount(@RequestBody T object, @PathVariable K id) {
        IdObtainable<K> idObtainable = (IdObtainable<K>) object;
        if (!idObtainable.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        if (!service.update(object)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
