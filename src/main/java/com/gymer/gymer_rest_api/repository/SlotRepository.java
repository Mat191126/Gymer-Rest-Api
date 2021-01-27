package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.implementation.Slot;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepositoryBehaviour<Slot, Integer> {
}
