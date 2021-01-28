package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Gym;
import com.gymer.gymer_rest_api.repository.CrudRepositoryBehaviour;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymService extends CrudService<Gym, Integer> {

    private final CalendarService calendarService;
    private final AddressService addressService;

    public GymService(@Qualifier("gymRepository") CrudRepositoryBehaviour<Gym, Integer> repository, CalendarService calendarService, AddressService addressService) {
        super(repository);
        this.calendarService = calendarService;
        this.addressService = addressService;
    }

    @Override
    public boolean update(Gym newGym) {
        Optional<Gym> oldGymOptional = get(newGym.getId());
        if (oldGymOptional.isPresent()) {
            Gym oldGym = oldGymOptional.get();
            oldGym.setName(newGym.getName());
            oldGym.setDescription(newGym.getDescription());
            oldGym.setOpenTime(newGym.getOpenTime());
            oldGym.setCloseTime(newGym.getCloseTime());
            oldGym.setAddress(newGym.getAddress());
            oldGym.setCalendar(newGym.getCalendar());
            oldGym.setEmployees(newGym.getEmployees());
            add(oldGym);
            return true;
        }
        return false;
    }

    @Override
    public final boolean delete(Integer id) {
        Optional<Gym> object = get(id);
        if (object.isPresent()) {
            Gym oldObject = object.get();
            oldObject.setActive(false);
            oldObject.setEmployees(null);
            addressService.delete(oldObject.getAddress().getId());
            calendarService.delete(oldObject.getCalendar().getId());
            repository.save(oldObject);
            return true;
        }
        return false;
    }

}
