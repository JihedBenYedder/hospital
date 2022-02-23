package com.alpha.hospital.service;

import com.alpha.hospital.model.dto.HospitalData;
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

    public Mono<Integer> getTotalBedsNumber() {
        return hospitalRepository
                .find("hospitalData").map(HospitalData::getTotalBedsNumber)
                .map(Mono::just).orElse(Mono.just(0));
    }

    public void setHospitalData(HospitalData hospitalData) {
        hospitalRepository.save("hospitalData",hospitalData);
    }


    public Mono<Integer> getOccupiedBedsNumber() {
        return hospitalRepository
                .find("hospitalData").map(HospitalData::getOccupiedBedsNumber)
                .map(Mono::just).orElse(Mono.just(0));
    }

    public Mono<HospitalData> getHospitalData() {
        return hospitalRepository.find("hospitalData").map(Mono::just).orElse(Mono.empty());
    }



    public void handlePatient() {
       hospitalRepository.find("hospitalData").map(data -> {
           Integer occupiedBeds = data.getOccupiedBedsNumber();
           Integer totalBedsNumber = data.getTotalBedsNumber();
           Integer occupancyRate = data.getOccupancyRate();
           if(totalBedsNumber - occupiedBeds > 0) {
               System.out.println("patient has covid");
               occupiedBeds=occupiedBeds+1;
               occupancyRate= (occupiedBeds/totalBedsNumber)*100;
           } else {
               System.out.println("Hospital is full");
           }
           data.setOccupiedBedsNumber(occupiedBeds);
           data.setOccupancyRate(occupancyRate);
           setHospitalData(data);
       });
    }

}
