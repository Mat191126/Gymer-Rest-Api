package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.implementation.Calendar;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends CrudRepositoryBehaviour<Calendar, Integer> {
}
