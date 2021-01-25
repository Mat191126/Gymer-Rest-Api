package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.Calendar;
import com.gymer.gymer_rest_api.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarService implements ICrudService<Calendar, Integer>{

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
	public void add(Calendar object) {
		calendarRepository.save(object);
	}

	@Override
	public void update(Calendar object) {
		Optional<Calendar> oldCalendar = get(object.getId());
		if (oldCalendar.isPresent()) {
			Calendar calendar = oldCalendar.get();
			calendar.setCalendarType(object.getCalendarType());
			add(calendar);
		}
	}
}
