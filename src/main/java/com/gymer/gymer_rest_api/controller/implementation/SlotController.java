package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.Gym;
import com.gymer.gymer_rest_api.entity.Slot;
import com.gymer.gymer_rest_api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slots")
public class SlotController extends RestApiController<Slot, Integer> {

    @Autowired
    public SlotController(CrudService<Slot, Integer> service) {
        super(service);
    }

}
