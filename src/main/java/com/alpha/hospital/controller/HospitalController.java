package com.alpha.hospital.controller;

import com.alpha.hospital.configuration.RedisProperties;
import com.alpha.hospital.model.dto.HospitalData;
import com.alpha.hospital.service.HospitalService;
import io.swagger.models.auth.In;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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


    @CrossOrigin(allowedHeaders = "*")
    @GetMapping(value = "/data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<HospitalData> getHospitalData() {

        return Flux.interval(Duration.ofSeconds(1))
                .flatMap(it -> hospitalService.getHospitalData());
    }

}
