package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.Gym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends CrudRepository<Gym, Integer> {
}
