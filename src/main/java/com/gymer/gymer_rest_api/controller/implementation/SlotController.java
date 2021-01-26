package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.implementation.Slot;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slots")
public class SlotController extends RestApiController<Slot, Integer> {

    @Autowired
    public SlotController(CrudBehaviour<Slot, Integer> service) {
        super(service);
    }

}
