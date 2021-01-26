package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Address;
import com.gymer.gymer_rest_api.entity.implementation.Calendar;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarService extends CrudService<Calendar, Integer> {

    @Autowired
    public CalendarService(CrudRepository<Calendar, Integer> repository) {
        super(repository);
    }

    @Override
    public boolean update(Calendar newCalendar) {
        Optional<Calendar> oldCalendarOptional = get(newCalendar.getId());
        if (oldCalendarOptional.isPresent()) {
            Calendar oldCalendar = oldCalendarOptional.get();
            oldCalendar.setSlots(newCalendar.getSlots());
            oldCalendar.setCalendarType(newCalendar.getCalendarType());
            add(oldCalendar);
            return true;
        }
        return false;
    }

}
