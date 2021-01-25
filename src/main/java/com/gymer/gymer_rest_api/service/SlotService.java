package com.gymer.gymer_rest_api.service;

import com.gymer.gymer_rest_api.entity.Slot;
import com.gymer.gymer_rest_api.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SlotService implements ICrudService<Slot, Integer>{

	private final SlotRepository slotRepository;

	@Autowired
	public SlotService(SlotRepository slotRepository) {
		this.slotRepository = slotRepository;
	}

	@Override
	public Iterable<Slot> getAll() {
		return slotRepository.findAll();
	}

	@Override
	public Optional<Slot> get(Integer id) {
		return slotRepository.findById(id);
	}

	@Override
	public void add(Slot object) {
		slotRepository.save(object);
	}

	@Override
	public void update(Slot object) {
		Optional<Slot> oldSlot = get(object.getId());
		if(oldSlot.isPresent()) {
			Slot slot = oldSlot.get();
			slot.setAddress(object.getAddress());
			slot.setCalendar(object.getCalendar());
			slot.setEndTime(object.getEndTime());
			slot.setStartTime(object.getStartTime());
			slot.setOccupied(object.isOccupied());
			add(slot);
		}
	}
}
