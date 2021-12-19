package com.alpha.hospital.controller;

import com.alpha.hospital.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping(value = "/beds/total")
    public int getBedsTotalNumber() {
        return hospitalService.getBedsTotalNumber();
    }

    @GetMapping(value = "/beds/occupied")
    public int getOccupiedBedsNumber() {
        return hospitalService.getOccupiedBedsNumber();
    }


}
