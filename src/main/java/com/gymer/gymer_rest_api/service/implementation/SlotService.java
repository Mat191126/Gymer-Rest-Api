package com.gymer.gymer_rest_api.service.implementation;

import com.gymer.gymer_rest_api.entity.implementation.Slot;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SlotService extends CrudService<Slot, Integer> {

    public SlotService(CrudRepository<Slot, Integer> repository) {
        super(repository);
    }

    @Override
    public boolean update(Slot newSlot) {
        Optional<Slot> oldSlotOptional = get(newSlot.getId());
        if (oldSlotOptional.isPresent()) {
            Slot oldSlot = oldSlotOptional.get();
            oldSlot.setAddress(newSlot.getAddress());
            oldSlot.setEndTime(newSlot.getEndTime());
            oldSlot.setStartTime(newSlot.getStartTime());
            oldSlot.setOccupied(newSlot.isOccupied());
            add(oldSlot);
            return true;
        }
        return false;
    }

    @Override
    public final boolean delete(Integer id) {
        Optional<Slot> object = get(id);
        if (object.isPresent()) {
            Slot oldObject = object.get();
            oldObject.setActive(false);
            repository.save(oldObject);
            return true;
        }
        return false;
    }

}
