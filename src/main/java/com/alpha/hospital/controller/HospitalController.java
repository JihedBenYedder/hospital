package com.alpha.hospital.controller;

import com.alpha.hospital.model.dto.HospitalData;
import com.alpha.hospital.service.HospitalService;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping(value = "/beds/total")
    public Mono<Integer> getTotalBedsNumber() {
        return hospitalService.getTotalBedsNumber();
    }

    @GetMapping(value = "/beds/occupied")
    public Mono<Integer> getOccupiedBedsNumber() {
        return hospitalService.getOccupiedBedsNumber();
    }

    @PutMapping(value = "/data")
    public Mono setHospitalData(@RequestBody HospitalData hospitalData) {
        return hospitalService.setHospitalData(hospitalData);
    }

}
