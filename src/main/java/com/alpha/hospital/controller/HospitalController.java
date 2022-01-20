package com.alpha.hospital.controller;

import com.alpha.hospital.model.dto.HospitalData;
import com.alpha.hospital.service.HospitalService;
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
    public Mono<String> getTotalBedsNumber() {
        return hospitalService.getTotalBedsNumber();
    }

    @GetMapping(value = "/beds/occupied")
    public Mono getOccupiedBedsNumber() {
        return hospitalService.getOccupiedBedsNumber();
    }

    @PutMapping(value = "/beds/total")
    public Mono setTotalBedsNumber(@RequestParam Integer totalBedsNumber) {
        return hospitalService.setTotalBedsNumber(totalBedsNumber);
    }

    @PutMapping(value = "/beds/occupied")
    public Mono setOccupiedBedsNumber(@RequestParam Integer occupiedBedsNumber) {
        return hospitalService.setOccupiedBedsNumber(occupiedBedsNumber);
    }


}
