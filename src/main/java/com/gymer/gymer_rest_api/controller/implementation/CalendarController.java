package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.implementation.Calendar;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController extends RestApiController<Calendar, Integer> {

    @Autowired
    public CalendarController(CrudBehaviour<Calendar, Integer> service) {
        super(service);
    }

}
