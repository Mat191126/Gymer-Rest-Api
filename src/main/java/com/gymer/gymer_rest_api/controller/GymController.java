package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Gym;
import com.gymer.gymer_rest_api.service.implementation.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Gym> getAll() {
        return gymService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gym getById(@PathVariable Integer id) {
        return gymService.get(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewAddress(@RequestBody Gym gym) {
        return gymService.add(gym) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAddress(@RequestBody Gym gym, @PathVariable Integer id) {
        if (!gym.getId().equals(id)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return gymService.update(gym) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
