package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Calendar;
import com.gymer.gymer_rest_api.entity.implementation.Slot;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarService extends CrudService<Calendar, Integer> {

    private final SlotService slotService;

    @Autowired
    public CalendarService(CrudRepository<Calendar, Integer> repository, SlotService slotService) {
        super(repository);
        this.slotService = slotService;
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

    @Override
    public final boolean delete(Integer id) {
        Optional<Calendar> object = get(id);
        if (object.isPresent()) {
            Calendar oldObject = object.get();
            oldObject.setActive(false);
            for (Slot slot : oldObject.getSlots()) {
                slotService.delete(slot.getId());
            }
            repository.save(oldObject);
            return true;
        }
        return false;
    }

}
