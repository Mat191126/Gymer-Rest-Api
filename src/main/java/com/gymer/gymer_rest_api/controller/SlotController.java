package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Slot;
import com.gymer.gymer_rest_api.service.implementation.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Slot> getAll() {
        return slotService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Slot getById(@PathVariable Integer id) {
        return slotService.get(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewSlot(@RequestBody Slot slot) {
        return slotService.add(slot) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateSlot(@RequestBody Slot slot, @PathVariable Integer id) {
        if (!slot.getId().equals(id)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return slotService.update(slot) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
