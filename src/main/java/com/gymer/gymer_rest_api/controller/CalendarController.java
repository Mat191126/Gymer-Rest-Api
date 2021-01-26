package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Calendar;
import com.gymer.gymer_rest_api.service.implementation.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarservice) {
        this.calendarService = calendarservice;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Calendar> getAll() {
        return calendarService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Calendar getById(@PathVariable Integer id) {
        return calendarService.get(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewCalendar(@RequestBody Calendar calendar) {
        return calendarService.add(calendar) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCalendar(@RequestBody Calendar calendar, @PathVariable Integer id) {
        if (!calendar.getId().equals(id)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return calendarService.update(calendar) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
