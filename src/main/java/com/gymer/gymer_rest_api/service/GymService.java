package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.Gym;
import com.gymer.gymer_rest_api.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymService implements ICrudService<Gym, Integer> {

    private final GymRepository gymRepository;

    @Autowired
    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @Override
    public Iterable<Gym> getAll() {
        return gymRepository.findAll();
    }

    @Override
    public Optional<Gym> get(Integer id) {
        return gymRepository.findById(id);
    }

    @Override
    public void add(Gym object) {
        gymRepository.save(object);
    }

    @Override
    public void update(Gym object) {
        Optional<Gym> gymDetailsOptional = get(object.getId());
        if (gymDetailsOptional.isPresent()) {
            Gym gym = gymDetailsOptional.get();
            gym.setName(object.getName());
            gym.setDescription(object.getDescription());
            gym.setOpenTime(object.getOpenTime());
            gym.setCloseTime(object.getCloseTime());
            gym.setAddress(object.getAddress());
            gym.setCalendar(object.getCalendar());
            gym.setEmployees(object.getEmployees());
            add(gym);
        }
    }

}
