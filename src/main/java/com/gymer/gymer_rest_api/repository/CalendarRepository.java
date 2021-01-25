package com.gymer.gymer_rest_api.repository;

import com.gymer.gymer_rest_api.entity.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Integer> {
}
