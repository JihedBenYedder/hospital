package com.alpha.hospital.service;

import com.alpha.hospital.model.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HospitalService {


    HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Mono getTotalBedsNumber() {
        return hospitalRepository.find("totalBeds");
    }

    public Mono setTotalBedsNumber(Integer totalBedsNumber) {
        return hospitalRepository.save("totalBeds",totalBedsNumber.toString());
    }

    public Mono setOccupiedBedsNumber(Integer occupiedBedsNumber) {
        return hospitalRepository.save("occupiedBeds",occupiedBedsNumber.toString());
    }

    public Mono getOccupiedBedsNumber() {
        return hospitalRepository.find("occupiedBeds");
    }
}
