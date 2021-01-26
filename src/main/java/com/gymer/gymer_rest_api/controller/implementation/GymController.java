package com.gymer.gymer_rest_api.controller.implementation;

import com.gymer.gymer_rest_api.controller.RestApiController;
import com.gymer.gymer_rest_api.entity.implementation.Gym;
import com.gymer.gymer_rest_api.service.CrudBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gyms")
public class GymController extends RestApiController<Gym, Integer> {

    @Autowired
    public GymController(CrudBehaviour<Gym, Integer> service) {
        super(service);
    }

}
