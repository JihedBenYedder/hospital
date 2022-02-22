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
        HospitalData ht = new HospitalData(45,45,45);
        return setHospitalData(ht);
      /*  hospitalRepository.find("hospitalData") // (1)
                .transform(HospitalService::transform)
                .subscribe(t -> System.out.println("dsfddsf"));*/
    }

    private static Mono<HospitalData> transform(Mono<HospitalData> current) {
        return current;
    }

}
