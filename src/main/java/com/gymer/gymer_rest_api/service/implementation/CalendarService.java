package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.Calendar;
import com.gymer.gymer_rest_api.repository.CalendarRepository;
import com.gymer.gymer_rest_api.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarService implements ICrudService<Calendar, Integer> {

    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Iterable<Calendar> getAll() {
        return calendarRepository.findAll();
    }

    @Override
    public Optional<Calendar> get(Integer id) {
        return calendarRepository.findById(id);
    }

    @Override
    public boolean add(Calendar object) {
        calendarRepository.save(object);
        return calendarRepository.existsById(object.getId());
    }

    @Override
    public boolean update(Calendar object) {
        Optional<Calendar> oldCalendar = get(object.getId());
        if (oldCalendar.isPresent()) {
            Calendar calendar = oldCalendar.get();
            calendar.setSlots(object.getSlots());
            calendar.setCalendarType(object.getCalendarType());
            add(calendar);
            return true;
        }
        return false;
    }

}
