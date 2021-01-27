package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.implementation.Gym;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends CrudRepositoryBehaviour<Gym, Integer> {
}
