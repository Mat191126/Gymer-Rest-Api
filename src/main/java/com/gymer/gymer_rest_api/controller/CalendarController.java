package com.gymer.gymer_rest_api.controller;

import com.gymer.gymer_rest_api.entity.Calendar;
import com.gymer.gymer_rest_api.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarservice) {
        this.calendarService = calendarservice;
    }

    @GetMapping
    public Iterable<Calendar> getAll() {
        return calendarService.getAll();
    }

    @GetMapping("/{id}")
    public Calendar getById(@PathVariable Integer id) {
        return calendarService.get(id).orElse(null);
    }

    @PostMapping
    public void addNewCalendar(@RequestBody Calendar calendar) {
        calendarService.add(calendar);
    }

    @PutMapping("/{id}")
    public void updateCalendar(@RequestBody Calendar calendar, @PathVariable Integer id) {
        calendar.setId(id);
        calendarService.update(calendar);
    }

}
