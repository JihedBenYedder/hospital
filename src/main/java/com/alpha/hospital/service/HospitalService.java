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
        HospitalData hs = new HospitalData(45,45,45)
        hospitalRepository.save("hospitalData",hs);
      /* return hospitalRepository.find("hospitalData")
                .switchIfEmpty(Mono.error(new Exception("COMPUTER_NOT_FOUND")))// (1)
                .map(c -> {c.setOccupiedBedsNumber(45); return c;})
                .flatMap(d -> hospitalRepository.save("hospitalData",d));*/
    }

    private static Mono<HospitalData> transform(Mono<HospitalData> current) {
        return current;
    }

}
