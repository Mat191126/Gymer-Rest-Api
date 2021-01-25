package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Slot;
import com.gymer.gymer_rest_api.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/slot")
public class SlotController {

	private final SlotService slotService;

	@Autowired
	public SlotController(SlotService slotService) {
		this.slotService = slotService;
	}

	@GetMapping
	public Iterable<Slot> getAll() {
		return slotService.getAll();
	}

	@GetMapping("/{id}")
	public Slot getById(@PathVariable Integer id) {
		return slotService.get(id).orElse(null);
	}

	@PostMapping
	public void addNewSlot(@RequestBody Slot slot) {
		slotService.add(slot);
	}

	@PutMapping("/{id}")
	public void updateSlot(@RequestBody Slot slot, @PathVariable Integer id) {
		slot.setId(id);
		slotService.update(slot);
	}
}
