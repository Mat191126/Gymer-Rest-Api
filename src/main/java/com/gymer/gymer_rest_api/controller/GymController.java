package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Gym;
import com.gymer.gymer_rest_api.service.implementation.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gym")
public class GymController {

    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public Iterable<Gym> getAll() {
        return gymService.getAll();
    }

    @GetMapping("/{id}")
    public Gym getById(@PathVariable Integer id) {
        return gymService.get(id).orElse(null);
    }

    @PostMapping
    public void addNewAddress(@RequestBody Gym gym) {
        gymService.add(gym);
    }

    @PutMapping("/{id}")
    public void updateAddress(@RequestBody Gym gym, @PathVariable Integer id) {
        gym.setId(id);
        gymService.update(gym);
    }

}
