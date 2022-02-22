package com.alpha.hospital.service;

import com.alpha.hospital.model.dto.HospitalData;
import com.alpha.hospital.model.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Service
public class HospitalService {


    HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Mono<Integer> getTotalBedsNumber() {
        return hospitalRepository.find("hospitalData").map(HospitalData::getTotalBedsNumber);
    }

    public Mono setHospitalData(HospitalData hospitalData) {
        System.out.println("saving : "+hospitalData.getOccupiedBedsNumber());
        return hospitalRepository.save("hospitalData",hospitalData);
    }


    public Mono<Integer> getOccupiedBedsNumber() {
        return hospitalRepository.find("hospitalData").map(HospitalData::getOccupiedBedsNumber);
    }

    public Mono<HospitalData> getHospitalData() {
        return hospitalRepository.find("hospitalData");
    }



    public Mono handlePatient() {
        return hospitalRepository.find("hospitalData") // (1)
                .map(this::transform)   // (2)
                .defaultIfEmpty(new HospitalData(0,0,0))               // (3)
                .flatMap(this::setHospitalData);
    }

    private HospitalData transform(HospitalData current) {
        current.setOccupiedBedsNumber(current.getOccupiedBedsNumber()+1);
        return current;
    }

}
